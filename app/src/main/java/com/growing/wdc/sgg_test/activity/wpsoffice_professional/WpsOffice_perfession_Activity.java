package com.growing.wdc.sgg_test.activity.wpsoffice_professional;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;

import java.io.File;

public class WpsOffice_perfession_Activity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected Button btnUseWpsoffice;
    protected RelativeLayout activityWpsOfficePerfession;
    protected EditText edt_author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_wps_office_perfession_);
        initView();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("wpsoffice打开本地office");
        btnUseWpsoffice = (Button) findViewById(R.id.btn_use_wpsoffice);
        btnUseWpsoffice.setOnClickListener(this);
        activityWpsOfficePerfession = (RelativeLayout) findViewById(R.id.activity_wps_office_perfession_);
        edt_author = (EditText) findViewById(R.id.edt_author);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_use_wpsoffice:
                openFile(getSDPath() + "/readme.docx");
                break;
        }

    }

    public String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }

    private boolean openFile(String path)

    {

        Intent intent = new Intent();

        Bundle bundle = new Bundle();

        bundle.putString("OPEN_MODE", "Normal");

        //打开模式

        bundle.putBoolean("SEND_CLOSE_BROAD", true);

        //关闭时是否发送广播

        bundle.putString("THIRD_PACKAGE", "com.growing.wdc.sgg_test");

        //第三方应用的包名，用于对改应用合法性的验证

        bundle.putBoolean("CLEAR_TRACE", true);

        //设置批注用户名
        String userName = edt_author.getText().toString().equals("") ? "王大川" : edt_author.getText().toString();
        bundle.putString("UserName", userName);

        //打开文件时，在最近列表不显示该打开记录

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        intent.setAction(android.content.Intent.ACTION_VIEW);

        intent.setClassName("com.kingsoft.moffice_pro", "cn.wps.moffice.documentmanager.PreStartActivity2");


        File file = new File(path);

        if (file == null || !file.exists())

        {
            return false;

        }


        Uri uri = Uri.fromFile(file);

        intent.setData(uri);

        intent.putExtras(bundle);

        try

        {

            startActivity(intent);

        } catch (ActivityNotFoundException e)

        {

            e.printStackTrace();

            return false;

        }

        return true;

    }

}
