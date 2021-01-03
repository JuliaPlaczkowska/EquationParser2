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

public class CalculateValueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_value);
    }

    public void onCalculateValue(View view) {
        final TextView textView = (TextView) findViewById(R.id.tvResponse);
        final EditText editText = (EditText) findViewById(R.id.edtSimpleRequest);

        RequestQueue queue = Volley.newRequestQueue(this);
        String operation = "simplify";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, ("https://newton.now.sh/api/v2/:operation/:expression"+operation+"/"), response ->
        {
            textView.setText(response.substring(0,200));

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