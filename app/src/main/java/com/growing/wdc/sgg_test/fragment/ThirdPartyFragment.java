package com.growing.wdc.sgg_test.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.growing.wdc.sgg_test.Base.BaseFragment;
import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.activity.OkhttpActivity;
import com.growing.wdc.sgg_test.activity.pulltorefresh.PullToRefreshActivity;
import com.growing.wdc.sgg_test.activity.recyclerview.RecyclerViewActivity;
import com.growing.wdc.sgg_test.activity.wpsoffice_professional.WpsOffice_perfession_Activity;
import com.growing.wdc.sgg_test.adapter.CommonFrameFragmentAdapter;
import com.growing.wdc.sgg_test.adapter.ThirdFragmentAdapter;

/**
 * Created by Administrator on 2016-12-12.
 * 第三方 fragment
 */

public class ThirdPartyFragment extends BaseFragment {
    private static final String TAG = ThirdPartyFragment.class.getSimpleName();//得到类名
    private TextView textView;
    private ListView mlistview;
    private String[] s;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_third_frame, null);
        mlistview = (ListView) view.findViewById(R.id.listview);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = s[position];
                if (data.toLowerCase().equals("wpsoffice_professional")) {
                    Intent intent = new Intent(mContext, WpsOffice_perfession_Activity.class);
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
        s = new String[]{"wpsoffice_professional"};
        ThirdFragmentAdapter adp = new ThirdFragmentAdapter(mContext, s);
        mlistview.setAdapter(adp);
    }
}
