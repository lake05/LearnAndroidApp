package com.example.learnandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnandroidapp.database.UserDBHelper;
import com.example.learnandroidapp.entity.User;
import com.example.learnandroidapp.utils.ToastUtil;

public class ShopCartActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox ck_married;
    private SharedPreferences preferences;
    private UserDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        ck_married = findViewById(R.id.ck_married);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mHelper = UserDBHelper.getInstance(this);
        mHelper.openWriteLink();
        mHelper.openReadLink();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHelper.closeLink();
    }


    public void onInsert(View view) {
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        String height = et_height.getText().toString();
        String weight = et_weight.getText().toString();

        User user = new User(name, Integer.parseInt(age), Long.parseLong(height), Long.parseLong(weight), ck_married.isChecked());

        if (mHelper.insert(user) > 0){
            ToastUtil.show(this, "添加成功");
        }
    }

    public void onDelete(View view) {
    }

    public void onEdit(View view) {
    }

    public void onRead(View view) {
    }


}