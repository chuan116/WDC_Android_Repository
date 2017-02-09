package com.growing.wdc.sgg_test.activity.imageloader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;

public class ImageLoaderActivity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected Button btnListview;
    protected Button btnGridview;
    protected Button btnViewpager;
    protected LinearLayout activityImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_image_loader);
        initView();

    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnListview = (Button) findViewById(R.id.btn_listview);
        btnListview.setOnClickListener(this);
        btnGridview = (Button) findViewById(R.id.btn_gridview);
        btnGridview.setOnClickListener(this);
        btnViewpager = (Button) findViewById(R.id.btn_viewpager);
        btnViewpager.setOnClickListener(this);
        activityImageLoader = (LinearLayout) findViewById(R.id.activity_image_loader);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_listview:
                //跳转到listview demo页面
                intent.setClass(this, ImageloaderListviewActivity.class);
                break;
            case R.id.btn_gridview:
                break;
            case R.id.btn_viewpager:
                break;
        }
        this.startActivity(intent);

    }
}
