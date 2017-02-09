package com.growing.wdc.sgg_test.activity.pulltorefresh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.growing.wdc.sgg_test.R;

public class PullToRefreshActivity extends Activity implements View.OnClickListener {

    protected Button btnListview;
    protected Button btnGridview;
    protected Button btnFragment;
    protected Button btnListviewInViewpager;
    protected Button btnViewpager;
    protected Button btnWebview;
    protected LinearLayout activityPullToRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_pull_to_refresh);
        initView();
    }

    private void initView() {
        btnListview = (Button) findViewById(R.id.btn_listview);
        btnGridview = (Button) findViewById(R.id.btn_gridview);
        btnFragment = (Button) findViewById(R.id.btn_fragment);
        btnListviewInViewpager = (Button) findViewById(R.id.btn_listview_in_viewpager);
        btnViewpager = (Button) findViewById(R.id.btn_viewpager);
        btnWebview = (Button) findViewById(R.id.btn_webview);
        activityPullToRefresh = (LinearLayout) findViewById(R.id.activity_pull_to_refresh);
        btnListview.setOnClickListener(this);
        btnGridview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_listview:
                intent.setClass(this, PullToRefreshListActivity.class);
                break;
            case R.id.btn_gridview:
                intent.setClass(this, PullToRefreshGridActivity.class);
                break;
            case R.id.btn_fragment:
                break;
            case R.id.btn_listview_in_viewpager:
                break;
            case R.id.btn_viewpager:
                break;
            case R.id.btn_webview:
                break;

        }
        this.startActivity(intent);
    }
}
