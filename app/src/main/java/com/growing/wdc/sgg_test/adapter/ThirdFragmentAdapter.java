package com.growing.wdc.sgg_test.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-12-14.
 */

public class ThirdFragmentAdapter extends BaseAdapter {

    private Context mcontext;
    private String[] datas;

    public ThirdFragmentAdapter(Context context, String[] datas) {
        this.mcontext = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txt = new TextView(mcontext);
        txt.setPadding(10, 10, 10, 10);
        txt.setTextColor(Color.BLACK);
        txt.setTextSize(20);
        txt.setText(datas[position]);
        return txt;
    }
}
