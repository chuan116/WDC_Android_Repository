package com.growing.wdc.sgg_test.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.growing.wdc.sgg_test.Base.BaseFragment;

/**
 * Created by Administrator on 2016-12-12.
 * 自定义 fragment
 */

public class CustomFragment extends BaseFragment {
    private static final String TAG = CustomFragment.class.getSimpleName();//得到类名
    private TextView textView;

    @Override
    protected View initView() {
        Log.e(TAG, "自定义架Fragment页面被初始化");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initDate() {
        super.initDate();
        Log.e(TAG, "自定义Fragment页面的数据被初始化");
        textView.setText("自定义框架页面");
    }
}
