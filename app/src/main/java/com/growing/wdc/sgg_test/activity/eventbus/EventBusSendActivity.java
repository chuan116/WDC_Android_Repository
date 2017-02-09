package com.growing.wdc.sgg_test.activity.eventbus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.activity.eventbus.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EventBusSendActivity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected Button btnSend;
    protected Button btnToSendNian;
    protected TextView txtNian;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");//okhttp编码
    protected Button btnAysnc;
    OkHttpClient client = new OkHttpClient();
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_event_bus_send);
        initView();
    }

    private void initView() {
        pd = new ProgressDialog(this);
        pd.setMessage("正在异步获取数据");

        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setOnClickListener(this);
        btnToSendNian = (Button) findViewById(R.id.btn_to_send_nian);
        btnToSendNian.setOnClickListener(this);
        txtNian = (TextView) findViewById(R.id.txt_nian);
        btnAysnc = (Button) findViewById(R.id.btn_aysnc);
        btnAysnc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                //发送事件
                EventBus.getDefault().post(new MessageEvent("发送过来的数据"));

                break;
            case R.id.btn_to_send_nian:
                EventBus.getDefault().register(EventBusSendActivity.this);
                break;

            case R.id.btn_aysnc:
                EventBus.getDefault().register(this);
                pd.show();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        getDateFromPost();
                    }
                }.start();
                break;
        }

    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void MessageEventLister(String result) {
        pd.dismiss();
        txtNian.setText(result.substring(0, 50));
    }

    private void getDateFromPost() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String result = ok_post("http://api.m.mtime.cn/PageSubArea/TrailerList.api", "");
                    EventBus.getDefault().post(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
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

    /**
     * 粘性事件监听
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void StickyMessageBus(MessageEvent event) {
        txtNian.setText(event.name);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().register(this);
    }


}
