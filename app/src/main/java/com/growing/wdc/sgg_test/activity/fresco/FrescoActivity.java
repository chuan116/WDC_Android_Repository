package com.growing.wdc.sgg_test.activity.fresco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;

public class FrescoActivity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected Button btnProgress;
    protected Button btnCut;
    protected Button btnCorner;
    protected Button btnJj;
    protected Button btnGif;
    protected Button btnReuse;
    protected Button btnListener;
    protected Button btnRote;
    protected Button btnEdit;
    protected Button btnShow;
    protected RelativeLayout activityFresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_fresco);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_progress) {
            this.startActivity(new Intent(this, FrescoSpImgActivity.class));

        } else if (view.getId() == R.id.btn_cut) {
            this.startActivity(new Intent(this, FrescoCropActivity.class));

        } else if (view.getId() == R.id.btn_corner) {

        } else if (view.getId() == R.id.btn_jj) {

        } else if (view.getId() == R.id.btn_gif) {

        } else if (view.getId() == R.id.btn_reuse) {

        } else if (view.getId() == R.id.btn_listener) {

        } else if (view.getId() == R.id.btn_rote) {

        } else if (view.getId() == R.id.btn_edit) {

        } else if (view.getId() == R.id.btn_show) {

        }
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnProgress = (Button) findViewById(R.id.btn_progress);
        btnProgress.setOnClickListener(FrescoActivity.this);
        btnCut = (Button) findViewById(R.id.btn_cut);
        btnCut.setOnClickListener(FrescoActivity.this);
        btnCorner = (Button) findViewById(R.id.btn_corner);
        btnCorner.setOnClickListener(FrescoActivity.this);
        btnJj = (Button) findViewById(R.id.btn_jj);
        btnJj.setOnClickListener(FrescoActivity.this);
        btnGif = (Button) findViewById(R.id.btn_gif);
        btnGif.setOnClickListener(FrescoActivity.this);
        btnReuse = (Button) findViewById(R.id.btn_reuse);
        btnReuse.setOnClickListener(FrescoActivity.this);
        btnListener = (Button) findViewById(R.id.btn_listener);
        btnListener.setOnClickListener(FrescoActivity.this);
        btnRote = (Button) findViewById(R.id.btn_rote);
        btnRote.setOnClickListener(FrescoActivity.this);
        btnEdit = (Button) findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(FrescoActivity.this);
        btnShow = (Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(FrescoActivity.this);
        activityFresco = (RelativeLayout) findViewById(R.id.activity_fresco);
    }
}
