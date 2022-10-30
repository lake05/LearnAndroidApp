package com.example.learnandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private TextView tv_result;

    private String firstNum = "";
    private String operator = "";
    private String secondNum = "";
    private String result = "";
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tv_result = findViewById(R.id.tv_result);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        String inputText = ((TextView) v).getText().toString();
        switch (v.getId()) {
            case R.id.btn_cancel:
                break;
            case R.id.btn_clear:
                clear();
                break;
            case R.id.btn_divide:
            case R.id.btn_multiply:
            case R.id.btn_minus:
            case R.id.btn_plus:
                operator = inputText;
                refreshText(showText + operator);
                break;
            case R.id.btn_equal:
                double calculate_result = calculateFour();
                refreshOperate(String.valueOf(calculate_result));
                refreshText(showText + "=" + result);
                break;
            case R.id.btn_sqrt:
                double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
                refreshOperate(String.valueOf(sqrt_result));
                refreshText(showText + "√=" + result);
                break;
            case R.id.btn_reciprocal:
                double reciprocal_result = 1.0 / Double.parseDouble(firstNum);
                refreshOperate(String.valueOf(reciprocal_result));
                refreshText(showText + "/=" + reciprocal_result);
                break;
            default:
                if(result.length() > 0 && operator.equals("")){
                    clear();
                }

                if (operator.equals("")) {
                    firstNum = firstNum + inputText;
                } else {
                    secondNum = secondNum + inputText;
                }

                if (showText.equals("0") && !inputText.equals(".")) {
                    refreshText(inputText);
                } else {
                    refreshText(showText + inputText);
                }

                break;
        }
    }

    private double calculateFour() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "×":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            default:
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
    }

    private void clear() {
        refreshOperate("");
        refreshText("");
    }

    private void refreshOperate(String new_result) {
        result = new_result;
        firstNum = new_result;
        secondNum = "";
        operator = "";
    }

    // 刷新文本显示
    private void refreshText(String text) {
        showText = text;
        tv_result.setText(showText);
    }


}