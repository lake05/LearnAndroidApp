package com.example.learnandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.learnandroidapp.utils.DateUtil;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = "ning";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "LifeCycleActivity onCreate");
        setContentView(R.layout.activity_life_cycle);

        TextView tv_receive = findViewById(R.id.tv_receive);

        // 从上一个页面传来的bundle
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String desc = String.format("收到请求消息：\n请求时间为：%s\n请求内容为：%s", request_time, request_content);
        tv_receive.setText(desc);
    }

    public void onResponse(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("response_time", DateUtil.getNowTime());
        bundle.putString("response_content", "thank you!");
        intent.putExtras(bundle);
        // 携带意图返回上一个页面，RESULT_OK 表示处理成功
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "LifeCycleActivity onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "LifeCycleActivity onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "LifeCycleActivity onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "LifeCycleActivity onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "LifeCycleActivity onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "LifeCycleActivity onRestart");

    }
}