package com.senon.module_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.senon.lib_common.ConstantArouter;
import com.senon.lib_common.ConstantLoginArouter;
import com.senon.lib_common.utils.StatusBarUtils;

/**
 * one test页面
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.with(this).init();
        setContentView(R.layout.one_activity_test);

    }

    public void toA(View view){
        ARouter.getInstance().build(ConstantLoginArouter.PATH_COMMON_LOGINACTIVITY)//指定跳到那个页面
                .withString("targetUrl", ConstantLoginArouter.PATH_ONE_MAINACTIVITY)//传入目标页面路由地址  可以在指定页面跳入到目标页面
                .navigation();

    }

}

