package com.growing.wdc.sgg_test.activity.fresco;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growing.wdc.sgg_test.R;

public class FrescoCropActivity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected SimpleDraweeView myImageView;
    protected Button btnFocuscrop;
    protected Button btnCenterinside;
    protected Button btnFitcenter;
    protected Button btnFitstart;
    protected Button btnFitend;
    protected Button btnFitxy;
    protected LinearLayout activityFrescoCrop;
    private GenericDraweeHierarchyBuilder builder;
    protected TextView txt_description;
    private Button btnNone;
    private Button centercrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_fresco_crop);
        initView();
        builder = new GenericDraweeHierarchyBuilder(getResources());

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_title) {

        } else if (view.getId() == R.id.my_image_view) {

        } else if (view.getId() == R.id.btn_focuscrop) {

            txt_description.setText("同centerCrop，但注重点不是中点，而是指定的某个点，这里我设置为图片的左上角那点");
            PointF point = new PointF(0, 0);
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).setActualImageFocusPoint(point).build();
            imageDisplay(hierarchy);

        } else if (view.getId() == R.id.btn_centerinside) {
            txt_description.setText("使两遍都在显示边界内，居中显示，如果图片尺寸大于显示边界，则保持长宽比缩小图片");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE)
                    .build();
            imageDisplay(hierarchy);

        } else if (view.getId() == R.id.btn_fitcenter) {
            txt_description.setText("保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，居中显示");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                    .build();
            imageDisplay(hierarchy);
        } else if (view.getId() == R.id.btn_fitstart) {
            txt_description.setText("保持宽高比，缩小或者放大，布局中，和显示边界左上对齐");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START)
                    .build();
            imageDisplay(hierarchy);
        } else if (view.getId() == R.id.btn_fitend) {
            txt_description.setText("保持宽高比，缩小或者放大，布局中，和显示边界右下对齐");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END)
                    .build();
            imageDisplay(hierarchy);
        } else if (view.getId() == R.id.btn_fitxy) {
            txt_description.setText("不保持宽高比填充满显示边界");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY)
                    .build();
            imageDisplay(hierarchy);
        } else if (view.getId() == R.id.btn_centercrop) {
            txt_description.setText("保持宽高比缩小或放大,使得两边都大于或等于显示边界，居中显示");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
            imageDisplay(hierarchy);
        } else if (view.getId() == R.id.btn_none) {
            txt_description.setText("如需要使用title mode显示 ，需要设置为none");
            GenericDraweeHierarchy hierarchy = builder.setActualImageScaleType(null).build();
            imageDisplay(hierarchy);
        }
    }

    private void imageDisplay(GenericDraweeHierarchy hierarchy) {
        myImageView.setHierarchy(hierarchy);
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488782905&di=e95f234f983784d5de15da90e8539d42&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F0e655ca7aa7da9d1d14358b7.jpg");
        myImageView.setImageURI(uri);
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setOnClickListener(FrescoCropActivity.this);
        myImageView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        myImageView.setOnClickListener(FrescoCropActivity.this);
        btnFocuscrop = (Button) findViewById(R.id.btn_focuscrop);
        btnFocuscrop.setOnClickListener(FrescoCropActivity.this);
        btnCenterinside = (Button) findViewById(R.id.btn_centerinside);
        btnCenterinside.setOnClickListener(FrescoCropActivity.this);
        btnFitcenter = (Button) findViewById(R.id.btn_fitcenter);
        btnFitcenter.setOnClickListener(FrescoCropActivity.this);
        btnFitstart = (Button) findViewById(R.id.btn_fitstart);
        btnFitstart.setOnClickListener(FrescoCropActivity.this);
        btnFitend = (Button) findViewById(R.id.btn_fitend);
        btnFitend.setOnClickListener(FrescoCropActivity.this);
        btnFitxy = (Button) findViewById(R.id.btn_fitxy);
        btnFitxy.setOnClickListener(FrescoCropActivity.this);
        activityFrescoCrop = (LinearLayout) findViewById(R.id.activity_fresco_crop);
        txt_description = (TextView) findViewById(R.id.txt_description);
        btnNone = (Button) findViewById(R.id.btn_none);
        btnNone.setOnClickListener(this);
        centercrop = (Button) findViewById(R.id.btn_centercrop);
        centercrop.setOnClickListener(this);
    }
}
