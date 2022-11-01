package com.example.learnandroidapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learnandroidapp.utils.DateUtil;

public class MainActivity extends AppCompatActivity {
    private TextView tv_response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_response = findViewById(R.id.tv_response);

        String value = getString(R.string._0);
    }


    public void goCalculator(View view) {
        startActivity(new Intent(this, Calculator.class));
    }

    public void goStorageActivity(View view) {
        startActivity(new Intent(this, StorageActivity.class));
    }

    public void goLifeCycleActivity(View view) {
        Intent intent = new Intent(this, LifeCycleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", "welcome back home");
        intent.putExtras(bundle);
        mGetContent.launch(intent);
    }

    public void goLoginMainActivity(View view) {
        startActivity(new Intent(this, LoginMainActivity.class));
    }

    // 针对 activity 结果注册回调
    private final ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result != null) {
                        Intent intent = result.getData();
                        if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                            Bundle bundle = intent.getExtras();
                            String response_time = bundle.getString("response_time");
                            String response_content = bundle.getString("response_content");
                            String desc = String.format("收到返回消息：\n返回时间为：%s\n返回内容为：%s", response_time, response_content);
                            tv_response.setText(desc);

                        }
                    }
                }
            }
    );

}