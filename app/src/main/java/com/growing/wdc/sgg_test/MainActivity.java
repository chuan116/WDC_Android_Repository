package com.growing.wdc.sgg_test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.growing.wdc.sgg_test.Base.BaseFragment;
import com.growing.wdc.sgg_test.fragment.CommonFrameFragment;
import com.growing.wdc.sgg_test.fragment.CustomFragment;
import com.growing.wdc.sgg_test.fragment.OthersFragment;
import com.growing.wdc.sgg_test.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    private int currentPosition;//选中的fragment对应的位置
    private Fragment currentFragment;//当前展示的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化view
        initviews();
        //初始化fragment
        initFragment();
        //设置RadioGroup的监听
        setRdgListener();
    }

    private void setRdgListener() {
        mRg_main.setOnCheckedChangeListener(new myOnCheckChageListener());
        //设置默认选中常用框架
        mRg_main.check(R.id.rb_common_frame);
    }

    class myOnCheckChageListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_common_frame://常用框架
                    currentPosition = 0;
                    break;
                case R.id.rb_thirdparty://第三方
                    currentPosition = 1;
                    break;
                case R.id.rb_custom://自定义
                    currentPosition = 2;
                    break;
                case R.id.rb_other://其他
                    currentPosition = 3;
                    break;
                default:
                    currentPosition = 0;
                    break;
            }
            //根据位置得到对应的fragment并替换到布局中
            BaseFragment c_f = mBaseFragment.get(currentPosition);
            switchFragment(currentFragment, c_f);

        }
    }


    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {//不相等再切换
            currentFragment = to;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            //判断有没有被添加
            if (!to.isAdded()) {
                //没有被添加 from隐藏 添加to
                if (from != null) {
                    transaction.hide(from);
                }
                if (to != null) {
                    transaction.add(R.id.fl_content, to).commit();
                }
            } else {
                //已经被添加 from隐藏， 显示to
                transaction.hide(from);
                transaction.show(to).commit();
            }

        }

    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFrameFragment());
        mBaseFragment.add(new ThirdPartyFragment());
        mBaseFragment.add(new CustomFragment());
        mBaseFragment.add(new OthersFragment());
    }


    private void initviews() {
        mRg_main = (RadioGroup) this.findViewById(R.id.rg_main);

    }
}
