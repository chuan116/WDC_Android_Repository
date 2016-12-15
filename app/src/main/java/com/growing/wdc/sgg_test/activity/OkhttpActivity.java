package com.growing.wdc.sgg_test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016-12-14.
 * OKhttp
 */
public class OkhttpActivity extends Activity implements View.OnClickListener {
    private static final String TAG = OkhttpActivity.class.getSimpleName();//得到类名
    private static final int GETOK = 12345;
    private static final int POSTOK = 45678;
    protected Button btnGet;
    protected Button btnPost;
    protected TextView txt_result;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");//okhttp编码
    OkHttpClient client = new OkHttpClient();
    Handler muiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GETOK:
                    String result_GET = msg.obj.toString();
                    txt_result.setText(result_GET);
                    break;
                case POSTOK:
                    String result_POST = msg.obj.toString();
                    txt_result.setText(result_POST);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_okhttp);
        initView();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        getDateFromGet();
                    }
                }.start();

                break;
            case R.id.btn_post://使用原生的http请求数据
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        getDateFromPost();
                    }
                }.start();
                break;
            default:
                break;
        }

    }

    private void initView() {
        btnGet = (Button) findViewById(R.id.btn_get);
        btnGet.setOnClickListener(OkhttpActivity.this);
        btnPost = (Button) findViewById(R.id.btn_post);
        btnPost.setOnClickListener(OkhttpActivity.this);
        txt_result = (TextView) findViewById(R.id.txt_result);
    }


    /**
     * okhttp get请求
     */
    private String ok_get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * okhttp post请求
     */
    private String ok_post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private void getDateFromGet() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = ok_get("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
                    Log.e(TAG, result);
                    Message msg = new Message();
                    msg.what = GETOK;
                    msg.obj = result;
                    muiHandler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void getDateFromPost(){
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = ok_post("http://api.m.mtime.cn/PageSubArea/TrailerList.api","");
                    Log.e(TAG, result);
                    Message msg = new Message();
                    msg.what = POSTOK;
                    msg.obj = result;
                    muiHandler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
