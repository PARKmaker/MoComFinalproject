package com.example.mocomfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String htmlPageUri = "https://hanbat.ac.kr/prog/carteGuidance/kor/sub06_030301/C1/calendar.do";
    String source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = new WebView(this);
        //WebView 자바스크립트 활성화
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new MyJavascriptInterface(), "Android");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 자바스크립트 인터페이스로 연결되어 있는 getHTML를 실행
                // 자바스크립트 기본 메소드로 html 소스를 통째로 지정해서 인자로 넘김 .getElementsByTagName('body')[0]
                view.loadUrl("javascript:window.Android.getHtml(document.getElementsByTagName('tbody')[0].innerHTML);");
            }
        });
        webView.loadUrl(htmlPageUri);
    }
}