package com.growing.wdc.sgg_test.activity.imageloader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.adapter.imageloader.ListviewAdapter;

public class ImageloaderListviewActivity extends Activity {

    protected TextView tvTitle;
    protected ListView imageloaderListview;
    protected LinearLayout activityImageloaderListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_imageloader_listview);
        initView();

        tvTitle.setText("imageloader在listview中应用");
        imageloaderListview.setAdapter(new ListviewAdapter(this));


    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageloaderListview = (ListView) findViewById(R.id.imageloader_listview);
        activityImageloaderListview = (LinearLayout) findViewById(R.id.activity_imageloader_listview);
    }
}
