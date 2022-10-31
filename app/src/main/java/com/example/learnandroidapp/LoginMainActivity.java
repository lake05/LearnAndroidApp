package com.example.learnandroidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class LoginMainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        CheckBox ck_system = findViewById(R.id.cy_system);
        ck_system.setOnCheckedChangeListener(this);

        RadioGroup rb_gender = findViewById(R.id.rb_gender);
        rb_gender.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String desc = String.format("you %s this CheckBox", b ? "checked" : "unchecked");
        compoundButton.setText(desc);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }

    public void onBtnAlert(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dear Users");
        builder.setMessage("Are you sure uninstall me?");
        builder.setPositiveButton("uninstall", (dialog, which) -> {

        });

        builder.setNegativeButton("think again", (dialog, which) -> {
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}