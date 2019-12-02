package com.example.myrobustdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchExecutor;
import com.meituan.robust.RobustCallBack;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        // 加载 patch
        findViewById(R.id.load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new callBack()).start();
            }
        });
        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private class callBack implements RobustCallBack {

        @Override
        public void onPatchListFetched(boolean result, boolean isNet, List<Patch> patches) {

        }

        @Override
        public void onPatchFetched(boolean result, boolean isNet, Patch patch) {

        }

        @Override
        public void onPatchApplied(boolean result, Patch patch) {

        }

        @Override
        public void logNotify(String log, String where) {

        }

        @Override
        public void exceptionNotify(Throwable throwable, String where) {

        }
    }
}
