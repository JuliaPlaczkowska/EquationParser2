package com.example.equationparser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void valueRequestClick(View view) {

        EditText editText = findViewById(R.id.etEquation);
        Intent intent = new Intent(this, CalculateValueActivity.class);
        Polynomial poly = new Polynomial(editText.getText().toString());
        intent.putExtra("Polynomial", poly);
        startActivity(intent);
    }
    public void derivativeRequestClick(View view) {
        EditText editText = findViewById(R.id.etEquation);
        Intent intent = new Intent(this, DerivativeActivity.class);
        Polynomial poly = new Polynomial(editText.getText().toString());
        intent.putExtra("Polynomial", poly);
        startActivity(intent);
    }

}