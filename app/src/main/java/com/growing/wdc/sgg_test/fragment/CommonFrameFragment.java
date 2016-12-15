package com.growing.wdc.sgg_test.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.growing.wdc.sgg_test.Base.BaseFragment;
import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.activity.OkhttpActivity;
import com.growing.wdc.sgg_test.adapter.CommonFrameFragmentAdapter;

/**
 * Created by Administrator on 2016-12-12.
 * 常用框架 fragmetn
 */

public class CommonFrameFragment extends BaseFragment {
    private static final String TAG = CommonFrameFragment.class.getSimpleName();//得到类名
    private ListView mlistview;
    private String[] s;

    @Override
    protected View initView() {
        Log.e(TAG, "常用框架Fragment页面被初始化");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mlistview = (ListView) view.findViewById(R.id.listview);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = s[position];
                if(data.toLowerCase().equals("okhttp")){
                    Intent intent =  new Intent(mContext,OkhttpActivity.class);
                    mContext.startActivity(intent);
                }
                Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    protected void initDate() {
        super.initDate();
        Log.e(TAG, "常用框架Fragment页面的数据被初始化");
        //设置适配器
        s = new String[]{"okhttp", "xutils3", "Retrofit2"};
        CommonFrameFragmentAdapter adp = new CommonFrameFragmentAdapter(mContext, s);
        mlistview.setAdapter(adp);
    }
}
