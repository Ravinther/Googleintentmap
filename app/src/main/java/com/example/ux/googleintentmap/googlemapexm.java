package com.example.ux.googleintentmap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Ravi on 6/25/2016.
 */
public class googlemapexm extends FragmentActivity implements GoogleMap.OnMapClickListener {
    private GoogleMap gmap;
    @Override
    public void onMapClick(LatLng latLng) {
        gmap.addMarker(new MarkerOptions().position(latLng).title("My Application"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded()
    {
        if (gmap==null)
        {
            gmap=((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (gmap!=null)
            {
                setUpMap();
            }
        }
    }
    private void setUpMap()
    {
        gmap.addMarker(new MarkerOptions().position(new LatLng(13.090420,80.291711)).title("Welcome to Beach Station"));
        CameraUpdate center= CameraUpdateFactory.newLatLng(new LatLng(13.090420, 80.291711));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
        gmap.moveCamera(center);
        gmap.animateCamera(zoom);
    }
}

