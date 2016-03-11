package com.kminfosystems.android.mapintrigation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 9/3/16.
 */
public class SpinnerActivity extends  Activity{
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    String response_status;
    String response_msg;
    int flag = 0;
    private static String url = "http://express-it.optusnet.com.au/sample.json";
    public static final String TAG_SUCCESS = "response";
    Spinner spinner;
    TextView car,tran ;
    Button getLocatio;
    LocationModel locationModel;
    ArrayList<SpinnerResponce> countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);
        spinner = (Spinner) findViewById(R.id.spinner);
        car = (TextView) findViewById(R.id.car);
        tran = (TextView) findViewById(R.id.tran);
        getLocatio = (Button) findViewById(R.id.getLocation);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    SpinnerResponce spinnerResponce = countries.get(position);
                    FromcentralModel fromcentralModel = spinnerResponce.getFromcentral();
                    locationModel = spinnerResponce.getLocation();
                    car.setText(fromcentralModel.getCar());
                    tran.setText(fromcentralModel.getTrain());
                }catch (Exception e){
                    e.printStackTrace();
                }

                }
                @Override
                public void onNothingSelected (AdapterView < ? > parent){

                }
            }

            );
            getLocatio.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                Intent intent = new Intent(SpinnerActivity.this, MainActivity.class);
                intent.putExtra("Location", locationModel);
                startActivity(intent);
            }
            }

            );
            new

            loginAccess()

            .

            execute();
        }

        class loginAccess extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SpinnerActivity.this);
            pDialog.setMessage("spinnner...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... arg0) {
            try {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                JSONArray json = jsonParser.makeHttpRequest(url, "GET", params);
                Log.d("Create Response123=", json.toString());
                String myCustom_JSONResponse="";// in which we will keep our response after adding object element to it
                BaseResponse apiResponse = new BaseResponse();
                myCustom_JSONResponse="{\"data\":"+json.toString()+"}";
                Gson gson = new Gson();
                apiResponse = gson.fromJson(myCustom_JSONResponse, BaseResponse .class);
                apiResponse.getData();
                SpinnerResponce [] spinnerResponce = apiResponse.getData();
                countries = new ArrayList<>(Arrays.asList(spinnerResponce));
            }catch (Exception e){
                e.printStackTrace();
            }
            response_status = null;
            response_msg = null;
            return null;
        }
        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            try {
                CountryAdapter country_adapter = new CountryAdapter(SpinnerActivity.this, R.layout.country_list, countries);
                spinner.setAdapter(country_adapter);
            }catch (Exception e){
                e.printStackTrace();
            }

            if (response_msg != null) {
              //  Toast.makeText(SpinnerActivity.this, response_msg,).show();
                if (!response_status.equals("FAILURE")) {
                }
            }
        }

    }


}
