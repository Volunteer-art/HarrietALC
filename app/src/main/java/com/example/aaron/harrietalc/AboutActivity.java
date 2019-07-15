package com.example.aaron.harrietalc;

import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar bar=getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        WebView web=findViewById(R.id.webview_about);
        web.setWebViewClient(new webview());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://andela.com/alc");
    }

    public class webview extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent myIntent = new Intent(AboutActivity.this,MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
                return true;
                default:
                    return onOptionsItemSelected(item);
        }
    }
}
