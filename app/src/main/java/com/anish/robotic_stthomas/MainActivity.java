package com.anish.robotic_stthomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Button b1;
    EditText ed1,ed2;
    String getUname,getPass;

    String apilink="http://dummyapilist.herokuapp.com/addcourse";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.but);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getUname=ed1.getText().toString();
                getPass=ed2.getText().toString();

                if(getUname.equals("admin")&&getPass.equals("12345")){

                    Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                    startActivity(intent);

                    callapi();

                }
                else {
                    Toast.makeText(getApplicationContext(),"INVALID CREDENTIALS",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private void callapi() {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, apilink,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }


        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

    }
}
