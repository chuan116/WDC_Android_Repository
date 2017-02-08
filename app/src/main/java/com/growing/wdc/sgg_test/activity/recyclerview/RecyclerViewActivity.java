package com.growing.wdc.sgg_test.activity.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.growing.wdc.sgg_test.R;
import com.growing.wdc.sgg_test.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;

public class RecyclerViewActivity extends Activity implements View.OnClickListener {

    protected Button btnAdd;
    protected Button btnDelete;
    protected Button btnList;
    protected Button btnGrid;
    protected Button btnFlow;
    protected RecyclerView recyclerview;
    protected LinearLayout activityRecyclerView;

    protected TextView tv_title;
    private ArrayList<String> datas;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_recycler_view);
        initView();
        InitData();
        //设置recyclerview 适配器
        adapter = new MyRecyclerViewAdapter(this, datas);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
    }

    private void initView() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnList = (Button) findViewById(R.id.btn_list);
        btnGrid = (Button) findViewById(R.id.btn_grid);
        btnFlow = (Button) findViewById(R.id.btn_flow);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        activityRecyclerView = (LinearLayout) findViewById(R.id.activity_recycler_view);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(RecyclerViewActivity.class.getSimpleName());
        //设置点击事件
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnFlow.setOnClickListener(this);


    }

    private void InitData() {
        //准备数据集合
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i + "");

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_list:
                break;
            case R.id.btn_grid:
                break;
            case R.id.btn_flow:
                break;
            default:
                break;


        }

    }
}
