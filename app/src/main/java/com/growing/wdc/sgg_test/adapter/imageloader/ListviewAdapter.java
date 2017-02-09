package com.growing.wdc.sgg_test.adapter.imageloader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.activity.imageloader.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by Administrator on 2017-02-21.
 */

public class ListviewAdapter extends BaseAdapter {
    private Context mContext;
    private ImageLoader imageLoader;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showStubImage(R.mipmap.android)//设置下载期间显示的图片
            .showImageForEmptyUri(R.mipmap.android)//设置uri为空或错误的时候显示的图片
            .showImageOnFail(R.mipmap.android)//设置图片下载或解码过程中发生错误显示的图片
            .cacheInMemory(true)//设置下载的图片是否还存在内存中
            .cacheOnDisk(true)//设置现在的图片是否还存在SD卡中
            .displayer(new RoundedBitmapDisplayer(20))//设置成圆角图片
            .build();

    public ListviewAdapter(Context context) {
        this.mContext = context;
        //初始化 imageloader
        imageLoader = imageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.IMAGES[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取或创建 viewholder
        Viewholder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_imageloader_lisetview, null);
            holder = new Viewholder();
            holder.mimageview = (ImageView) convertView.findViewById(R.id.iv_imageloader);
            holder.mtextview = (TextView) convertView.findViewById(R.id.tv_imageloader);
            convertView.setTag(holder);
        } else {
            holder = (Viewholder) convertView.getTag();
        }
        //获取当前item数据

        //显示数据
        holder.mtextview.setText("当前是" + position + "item");

        imageLoader.displayImage(Constants.IMAGES[position], holder.mimageview, options);
        //返回view
        return convertView;
    }

    class Viewholder {
        ImageView mimageview;
        TextView mtextview;
    }
}
