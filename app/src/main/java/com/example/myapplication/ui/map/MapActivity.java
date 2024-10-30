package com.example.myapplication.ui.map;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.R;
import com.example.myapplication.data.database.DatabaseHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        databaseHelper = new DatabaseHelper(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Cursor cursor = databaseHelper.obtenerFotos();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                double latitude = cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_LATITUDE));
                double longitude = cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_LONGITUDE));
                byte[] photo = cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PHOTO));

                Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
                LatLng location = new LatLng(latitude, longitude);

                mMap.addMarker(new MarkerOptions()
                        .position(location)
                        .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                        .title("Foto tomada aquí"));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
            } while (cursor.moveToNext());
        }
    }
}
