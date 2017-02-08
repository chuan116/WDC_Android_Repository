package com.growing.wdc.sgg_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-02-08.
 * 作用 recyclerView 适配器
 */

public class MyRecyclerViewAdapter_Flow extends RecyclerView.Adapter<MyRecyclerViewAdapter_Flow.MyViewHolder> {

    private Context context;
    private ArrayList<String> datas;
    private List<Integer> heights;

    public MyRecyclerViewAdapter_Flow(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
        getRandomHeight(this.datas);
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
        // 随机高度, 模拟瀑布效果.
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,heights.get(position));//得到item的LayoutParams布局参数
        holder.itemView.setLayoutParams(params);//把params设置给item布局
        holder.tv_title.setText(data);
    }

    private void getRandomHeight(List<String> lists) {//得到随机item的高度

        heights = new ArrayList<>();

        for (int i = 0; i < lists.size(); i++) {

            heights.add((int) (200 + Math.random() * 400));

        }

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
