package com.anish.robotic_stthomas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl("http://192.168.31.245:8081/");

    }
}