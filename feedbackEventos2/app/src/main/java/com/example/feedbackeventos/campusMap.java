package com.example.feedbackeventos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class campusMap extends AppCompatActivity {

    FusedLocationProviderClient client;
    SupportMapFragment supportMapFragment;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_map);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_maps);
        client = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(campusMap.this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            getCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(campusMap.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

    }
    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {

                            mMap = googleMap;

                            LatLng mMyLocation = new LatLng(location.getLatitude(), location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(mMyLocation).title("Current Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.location));
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mMyLocation, 14));
                            googleMap.addMarker(options);

                            LatLng UAX = new LatLng(40.45214, -3.9881);
                            mMap.addMarker(new MarkerOptions().position(UAX).title("UAX").icon(BitmapDescriptorFactory.fromResource(R.drawable.location)));

                            LatLng Madrid = new LatLng(40.42583, -3.70111);
                            mMap.addMarker(new MarkerOptions().position(Madrid).title("Madrid").icon(BitmapDescriptorFactory.fromResource(R.drawable.location)));

                            LatLng VC = new LatLng(22.5726, 88.3639);
                            mMap.addMarker(new MarkerOptions().position(VC).title("Villanueva de la cañada").icon(BitmapDescriptorFactory.fromResource(R.drawable.location)));
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        }
    }
}

