package com.senon.module_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.senon.lib_common.ConstantLoginArouter;

/**
 * one 模块主页面
 */
@Route(path = ConstantLoginArouter.PATH_APP_MAINACTIVITY)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_activity_main);
    }
}
