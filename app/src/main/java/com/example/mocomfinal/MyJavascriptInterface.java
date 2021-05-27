package com.example.mocomfinal;

import android.util.Log;
import android.webkit.JavascriptInterface;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MyJavascriptInterface {
    @JavascriptInterface
    public void getHtml(String html) {
        //위 자바스크립트가 호출되면 여기로 html이 반환됨
        Log.e("박상현", html);

        new Thread(){
            public void run(){
                Document document = null;
                try {
                    document = Jsoup.parse(html);
                }//#coltable > tbody > tr:nth-child(2) > td:nth-child(2) > div
                catch (Exception e) {
                    e.printStackTrace();
                }

                Elements menu = document.select("div");
                for (Element headline : menu){
                    Log.e("박상현z", headline.text());
                }
            }
        }.start();

        //세컨드 커밋

        //마스터 브랜치 커밋
    }
}
