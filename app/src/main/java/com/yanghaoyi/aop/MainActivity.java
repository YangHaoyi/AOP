package com.yanghaoyi.aop;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvClick;
    private TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvClick = findViewById(R.id.tvClick);
        tvSecond = findViewById(R.id.tvSecond);
        tvClick.setOnClickListener(this);
        tvSecond.setOnClickListener(this);
        test();
    }

    @AspectJAnnotation(value = Manifest.permission.CAMERA)
    public void test(){
        Log.i("tag00","检查权限");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvClick:
                System.out.println("AOP_Click___________________:tvClick  点击事件");
                break;
            case R.id.tvSecond:
                System.out.println("AOP_Click___________________:tvSecond  点击事件");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("AOP_Click___________________:执行onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("AOP_Click___________________:执行onPause");
    }
}
