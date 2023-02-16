package com.example.feedbackeventos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feedbackeventos.R;

import java.net.URISyntaxException;

public class actividad6 extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6_page);

        web = findViewById(R.id.webView);

        WebSettings webSettings = web.getSettings();

        webSettings.setJavaScriptEnabled(true);

        web.setWebViewClient(new Callback());
        web.loadUrl("https://www.uax.com");
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            // By returning false you're telling Android that, this is my website, so, do not override;
            // let WebView load the page.
            return false;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (url.startsWith("intent")) {
                try {
                    Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                    String fallbackUrl = intent.getStringExtra("browser_fallback_url");
                    if (fallbackUrl != null) {
                        view.loadUrl(fallbackUrl);
                        return true;
                    }
                } catch (URISyntaxException e) {
                    // Syntax problem with uri
                }
            }
            if (url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                startActivity(intent);
            } else if (url.startsWith("mailto:")) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(url));
                startActivity(intent);
            }
            view.loadUrl(url);
            return false;
        }

    }

    // Additional code.
    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

