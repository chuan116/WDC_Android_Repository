package com.growing.wdc.sgg_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-08.
 * 作用 recyclerView 适配器
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> datas;

    public MyRecyclerViewAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    /***
     * 相当于 listview 中的 getview 创建 view和 viewholder
     */


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iteView = View.inflate(context, R.layout.item_recyclerview, null);
        return new MyViewHolder(iteView);

    }

    /**
     * 相当于 getview中的 绑定数据部分代码
     * 数据和view绑定
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //根据位置得到对应的数据
        String data = datas.get(position);
        holder.tv_title.setText(data);
    }

    /**
     * 得到总条数
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_icon;
        private TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
