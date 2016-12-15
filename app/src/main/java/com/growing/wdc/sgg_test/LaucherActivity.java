package com.growing.wdc.sgg_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class LaucherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //在主线程中执行
                startMainActivity();
            }
        },2000);
    }

    /**
     * 启动主界面
     * */
    private void startMainActivity(){
        Intent  intent  = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }
}
