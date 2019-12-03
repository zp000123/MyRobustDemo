package com.example.myrobustdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.meituan.robust.patch.annotaion.Modify;


public class SecondActivity extends AppCompatActivity {

    @Override
    @Modify
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        ((TextView) findViewById(R.id.tv_hint)).setText("Bug Fix2222");
    }

    @Modify // 修复的时候需要把 private 的方法改成 public 的
    public void initView() {
        ((TextView) findViewById(R.id.tv_hint)).setText("Bug");
        ((TextView) findViewById(R.id.tv_hint)).setText("Bug Fix ");
    }
}
