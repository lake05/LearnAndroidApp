package com.example.learnandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopCartActivity extends AppCompatActivity implements View.OnClickListener {

    private String mDatabaseName;
    private TextView tv_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);

        findViewById(R.id.btn_database_create).setOnClickListener(this);
        findViewById(R.id.btn_database_delete).setOnClickListener(this);
        mDatabaseName = getFilesDir() + "/test.db";
        tv_database = findViewById(R.id.tv_database);
    }

    @Override
    public void onClick(View v) {
        String desc = "";
        switch (v.getId()) {
            case R.id.btn_database_create:
                final SQLiteDatabase db = openOrCreateDatabase(mDatabaseName, Context.MODE_PRIVATE, null);
                desc = String.format("数据库%s创建成功", db.getPath());
                break;
            case R.id.btn_database_delete:
                boolean result = deleteDatabase(mDatabaseName);
                desc = String.format("数据库%s删除%s", mDatabaseName, result ? "成功" : "失败");
                break;
        }
        tv_database.setText(desc);
    }
}