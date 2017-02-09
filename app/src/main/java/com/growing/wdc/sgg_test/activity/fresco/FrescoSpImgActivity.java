package com.growing.wdc.sgg_test.activity.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growing.wdc.sgg_test.R;

public class FrescoSpImgActivity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected SimpleDraweeView myImageView;
    protected LinearLayout activityFrescoSpImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_fresco_sp_img);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_title) {

        } else if (view.getId() == R.id.my_image_view) {

        } else if (view.getId() == R.id.activity_fresco_sp_img) {

        }
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setOnClickListener(FrescoSpImgActivity.this);
        myImageView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        myImageView.setOnClickListener(FrescoSpImgActivity.this);
        //myImageView加载图片  设置样式
        GenericDraweeHierarchyBuilder b = new GenericDraweeHierarchyBuilder(this.getResources());
        GenericDraweeHierarchy mhier = b.setProgressBarImage(new ProgressBarDrawable()).build();
        myImageView.setHierarchy(mhier);
        //加载图片的地址
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488782905&di=e95f234f983784d5de15da90e8539d42&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F0e655ca7aa7da9d1d14358b7.jpg");
        myImageView.setImageURI(uri);
        activityFrescoSpImg = (LinearLayout) findViewById(R.id.activity_fresco_sp_img);
        activityFrescoSpImg.setOnClickListener(FrescoSpImgActivity.this);

    }
}
