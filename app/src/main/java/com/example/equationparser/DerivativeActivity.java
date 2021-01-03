package com.example.equationparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DerivativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivative);

        TextView textView = (TextView) findViewById(R.id.tvDerivative);
        Polynomial poly = (Polynomial)getIntent().getSerializableExtra("Polynomial");

        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String operation = "derive";
        String url = "https://newton.now.sh/api/v2/"+operation+"/"+poly.toString();
        System.out.println(url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
        {
            Result result = gson.fromJson(response, Result.class);
            textView.setText(result.getResult());
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        }
        );
        queue.add(stringRequest);

    }
}