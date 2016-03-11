package com.kminfosystems.android.mapintrigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    // Google Map
    private GoogleMap googleMap;
    double latitude ;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send = (Button) findViewById(R.id.sent);
        final LocationModel detailModel = (LocationModel) getIntent().getSerializableExtra("Location");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SpinnerActivity.class);
                startActivity(intent);
            }
        });

        try {
            // Loading map
            initilizeMap();

            // Changing map type
              googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
             //googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
             //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
           //  googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

            // Showing / hiding your current location
            googleMap.setMyLocationEnabled(true);

            // Enable / Disable zooming controls
            googleMap.getUiSettings().setZoomControlsEnabled(false);

            // Enable / Disable my location button
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            // Enable / Disable Compass icon
            googleMap.getUiSettings().setCompassEnabled(true);

            // Enable / Disable Rotate gesture
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            // Enable / Disable zooming functionality
            googleMap.getUiSettings().setZoomGesturesEnabled(true);
            if(detailModel !=null){
                latitude = detailModel.getLatitude();
                longitude = detailModel.getLongitude();
            }else {
                double latitude = 17.385044;
                double longitude = 78.486671;
            }
            // lets place some 10 random markers
            for (int i = 0; i < 1; i++) {
                // random latitude and logitude
                double[] randomLocation = createRandLocation(latitude,
                        longitude);
                // Adding a marker
                MarkerOptions marker = new MarkerOptions().position(
                        new LatLng(randomLocation[0], randomLocation[1]))
                        .title("Hello Maps " + i);

                Log.e("Random", "> " + randomLocation[0] + ", "
                        + randomLocation[1]);

                // changing marker color
                if (i == 0)
                    marker.icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));


                googleMap.addMarker(marker);

                // Move the camera to last position with a zoom level
                if (i == 0) {
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(randomLocation[0],
                                    randomLocation[1])).zoom(15).build();

                    googleMap.animateCamera(CameraUpdateFactory
                            .newCameraPosition(cameraPosition));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    /**
     * function to load map If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    /*
     * creating random postion around a location for testing purpose only
     */
    private double[] createRandLocation(double latitude, double longitude) {

        return new double[] { latitude + ((Math.random() - 0.5) / 500),
                longitude + ((Math.random() - 0.5) / 500),
                150 + ((Math.random() - 0.5) * 10) };
    }
}
