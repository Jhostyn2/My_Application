package com.example.myapplication.ui.menu;

import android.content.Intent;
import android.os.Bundle;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.ui.camera.CameraActivity;
import com.example.myapplication.ui.map.MapActivity;

public class MenuActivity extends AppCompatActivity {

    private Button takePhotoButton;
    private Button viewMapButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inicializar botones
        takePhotoButton = findViewById(R.id.takePhotoButton);
        viewMapButton = findViewById(R.id.viewMapButton);

        // Listener para botón de tomar foto
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        // Listener para botón de ver mapa
        viewMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}
