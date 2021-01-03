package com.example.equationparser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
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

public class CalculateValueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_value);
    }

    public void onCalculateValue(View view) {
        TextView textView = (TextView) findViewById(R.id.tvResponse);
        EditText editText = (EditText) findViewById(R.id.edtSimpleRequest);
        Polynomial poly = (Polynomial)getIntent().getSerializableExtra("Polynomial");

        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String operation = "simplify";
        String url = "https://newton.now.sh/api/v2/"+operation+"/"+poly.toSimplify(Integer.parseInt(editText.getText().toString()));
        //url = "https://newton.now.sh/api/v2/simplify/(2)%5E2";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
        {
            Result result = gson.fromJson(response, Result.class);
            textView.setText(result.getResult());
            //textView.setText("toSimplify: "+poly.toSimplify(Integer.parseInt(editText.getText().toString())));

            System.out.println(poly.toSimplify(Integer.parseInt(editText.getText().toString())));

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