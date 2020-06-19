package com.anish.robotic_stthomas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ViewTempActivity extends AppCompatActivity {
    String Api ="http://3.128.122.63/viewall_api.php";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_temp);
        tv=(TextView)findViewById(R.id.display);
        callApi();
    }

    private void callApi() {
        Log.d("test", Api);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.d("test", response);

//                            Toast.makeText(getActivity().getApplicationContext(), "Response From Server " + response, Toast.LENGTH_LONG).show();

                            JSONObject jsonObject = new JSONObject(response);

                            String rslt = jsonObject.getString("status");

                            if(rslt.equals("ok"))
                            {
                                String hum = jsonObject.getString("hum");
                                String temp = jsonObject.getString("temp");
                                String moist = jsonObject.getString("mosit");
                                tv.setText(temp);

                            }
                            else{

                                Toast.makeText(getApplicationContext().getApplicationContext(), "No Data Available ", Toast.LENGTH_LONG).show();


                            }




                        } catch (JSONException ob) {
                            Toast.makeText(getApplicationContext().getApplicationContext(), "Exception  " + ob, Toast.LENGTH_LONG).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("test", error.toString());


                    }
                }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();



                return params;

            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
