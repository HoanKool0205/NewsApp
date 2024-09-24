package com.androidexp.newsapp.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.androidexp.newsapp.R;

public class NewsDetailActivity extends AppCompatActivity {

    Toolbar toolbar1;
    WebView webView;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_tab);

        toolbar1 = findViewById(R.id.toolbar1);
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
//        setSupportActionBar(toolbar1);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(false);
        settings.setSupportZoom(false);

        webView.loadUrl(url);

    }
}
