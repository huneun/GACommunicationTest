package com.example.gacommunicationtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceResponse;

import io.github.mthli.Ninja.View.NinjaWebView;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    //private NinjaWebView ninjaWebView;
    private String url = "https://devm.dibidibi.com:454";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=(WebView)findViewById(R.id.webview);
//        ninjaWebView =(NinjaWebView)findViewById(R.id.ninjaWebView);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClientClass());
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if(0 != (getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE)){
//                ninjaWebView.setWebContentsDebuggingEnabled(true);
//            }
//        }
//
//        ninjaWebView.loadUrl(url);
//        ninjaWebView.setWebChromeClient(new WebChromeClient());
//        ninjaWebView.setWebViewClient(new WebViewClientClass());


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()){
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if((keyCode == KeyEvent.KEYCODE_BACK) && ninjaWebView.canGoBack()){
//            ninjaWebView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            Log.i("TEST_url", "InterceptRequest: "+request.getUrl());
            return super.shouldInterceptRequest(view, request);
        }
    }


}