package com.growing.wdc.sgg_test.activity.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.activity.eventbus.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

public class EventBusActivity extends Activity implements View.OnClickListener {

    protected TextView tvTitle;
    protected Button btnToSendActivity;
    protected Button btnToSendEvent;
    protected RelativeLayout activityEventBus;
    protected TextView tv_receive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_event_bus);
        initView();
        //注册广播
        EventBus.getDefault().register(this);

    }

    /**
     * 接受消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent event) {
        tv_receive.setText(event.name);

    }


    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnToSendActivity = (Button) findViewById(R.id.btn_to_send_activity);
        btnToSendActivity.setOnClickListener(this);
        btnToSendEvent = (Button) findViewById(R.id.btn_to_send_event);
        btnToSendEvent.setOnClickListener(this);
        activityEventBus = (RelativeLayout) findViewById(R.id.activity_event_bus);
        tv_receive = (TextView) findViewById(R.id.txt_receive);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_send_activity:
                Intent intent = new Intent();
                intent.setClass(EventBusActivity.this, EventBusSendActivity.class);
                EventBusActivity.this.startActivity(intent);
                break;
            case R.id.btn_to_send_event:
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件"));
                Intent intent2 = new Intent();
                intent2.setClass(EventBusActivity.this, EventBusSendActivity.class);
                EventBusActivity.this.startActivity(intent2);
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
