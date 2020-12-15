package com.example.quizappnative;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import java.util.Objects;

public class WebViewActivity extends AppCompatActivity {

    public static final String NAME_KEY = "SHAYAK_HABIB_PDF_NAME_KEY";
    public static final String LINK_KEY = "SHAYAK_HABIB_DRIVE_LINK_URL_KEY";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String title = intent.getStringExtra(NAME_KEY);
        String link = intent.getStringExtra(LINK_KEY);

        ProgressBar progressBar = findViewById(R.id.web_view_progress);

        webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);

        webView.loadUrl(link);

        webView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    downloader(url, userAgent, contentDisposition, mimetype);
                } else {
                    ActivityCompat.requestPermissions(WebViewActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    downloader(url, userAgent, contentDisposition, mimetype);
                }
            } else {
                downloader(url, userAgent, contentDisposition, mimetype);
            }
        });

        //Setting custom Toolbar
        Toolbar toolbar = findViewById(R.id.web_view_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void downloader(final String url, final String userAgent, final String contentDisposition, final String mimetype) {
        String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
        String cookie = CookieManager.getInstance().getCookie(url);

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request downloadRequest = new DownloadManager.Request(Uri.parse(url));
        downloadRequest.addRequestHeader("Cookie", cookie);
        downloadRequest.addRequestHeader("User-Agent", userAgent);
        downloadRequest.allowScanningByMediaScanner();
        downloadRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        downloadManager.enqueue(downloadRequest);

        Toast.makeText(WebViewActivity.this, "Downloading - " + fileName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            webView.clearCache(true);
            webView.clearHistory();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            webView.clearCache(true);
            webView.clearHistory();
            WebViewActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}