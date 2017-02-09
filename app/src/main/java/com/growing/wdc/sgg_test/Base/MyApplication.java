package com.growing.wdc.sgg_test.Base;

import android.app.Application;
import android.content.Context;

//import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Administrator on 2017-02-20.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initImageloader(this);
    }

    private void initImageloader(Context context) {
        //初始化参数
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)//线程优先级
                .denyCacheImageMultipleSizesInMemory()//当同一个uri获取不同大小的图片，缓存到内存是，只缓存一个,默认会缓存多个
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5
                .tasksProcessingOrder(QueueProcessingType.LIFO) //设置图片下载和显示的工作队列排序
                .writeDebugLogs()//打印 debug log
                .build();

        //初始化 全局配置
        ImageLoader.getInstance().init(config);

        //初始化 fresco
        Fresco.initialize(this);
    }
}
