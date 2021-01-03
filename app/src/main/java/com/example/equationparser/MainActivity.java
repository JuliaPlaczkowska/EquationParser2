package com.example.equationparser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final EditText editText = (EditText) findViewById(R.id.edtSimpleRequest);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void derivativeRequestClick(View view) {
        Intent intent = new Intent(this, DerivativeActivity.class);
        Polynomial poly = new Polynomial(editText.getText().toString());
        intent.putExtra("Polynomial", poly);
        startActivity(intent);
    }

    public void valueRequestClick(View view) {
        Intent intent = new Intent(this, CalculateValueActivity.class);
        Polynomial poly = new Polynomial(editText.getText().toString());
        intent.putExtra("Polynomial", poly);
        startActivity(intent);
    }
}