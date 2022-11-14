package com.twomonth.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import rxhttp.twomonth.RxHttp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyChronometer chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);

        RxHttp.get("https://www.baidu.com")  //第一步，确定请求类型，可以选择postForm、postJson等方法
                .toObservable(String.class)  //第二步，确定返回类型，这里返回String类型
                .subscribe(s -> {     //第三步，订阅观察者，第二步返回Observable对象
                    //请求成功
                }, throwable -> {
                    //请求失败
                });
    }
}