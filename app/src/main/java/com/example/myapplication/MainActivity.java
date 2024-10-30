package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.map.MapActivity;
import com.example.myapplication.ui.register.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnCamera = findViewById(R.id.btnCamera);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnMap = findViewById(R.id.btnMap);

        btnLogin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        btnCamera.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, com.example.myapplication.ui.camera.CameraActivity.class)));
        btnRegister.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegistroActivity.class)));
        btnMap.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MapActivity.class)));
    }
}
