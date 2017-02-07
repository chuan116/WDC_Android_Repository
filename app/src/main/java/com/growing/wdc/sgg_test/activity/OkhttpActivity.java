package com.growing.wdc.sgg_test.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.growing.wdc.sgg_test.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;

import okhttp3.Call;
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
    protected Button btn_post_okhttp_utils;
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

    MyStringCallback httputilsCallBack = new MyStringCallback();

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

            case R.id.btn_post_okhttp_utils:
                getDataByOkhttpUtil();
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
        btn_post_okhttp_utils = (Button) findViewById(R.id.btn_post_okhttp_utils);
        btn_post_okhttp_utils.setOnClickListener(this);
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

    private void getDateFromPost() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = ok_post("http://api.m.mtime.cn/PageSubArea/TrailerList.api", "");
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

    /**
     * okhttputils
     */
    public void getDataByOkhttpUtil() {
        //通过httputils框架 post请求
//        String weatherURL = "https://api.thinkpage.cn/v3/weather/now.json?key=5emeqa2c0nqszhdc&location=beijing&language=zh-Hans&unit=c";
        String weatherURL = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .post()
                .url(weatherURL)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(httputilsCallBack);
    }


    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id) {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            txt_result.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            txt_result.setText("onResponse:" + response);

            switch (id) {
                case 100:
                    Toast.makeText(OkhttpActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(OkhttpActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
//            mProgressBar.setProgress((int) (100 * progress));
            txt_result.setText("Loadding");

        }
    }
}
