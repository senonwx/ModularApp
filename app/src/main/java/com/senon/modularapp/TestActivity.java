package com.senon.modularapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.senon.lib_common.ConstantArouter;
import com.senon.lib_common.ConstantLoginArouter;
import com.senon.lib_common.utils.StatusBarUtils;

/**
 * app test页面
 */
@Route(path = ConstantArouter.PATH_APP_TESTACTIVITY)
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.with(this).init();
        setContentView(R.layout.activity_test);

    }

    public void toA(View view){
//        应用内简单的跳转
//        String curUrl = ConstantLoginArouter.getCurRouter(this.getClass().getSimpleName());
//        String curUrl = ConstantLoginArouter.getCurRouter(ConstantLoginArouter.PATH_HOME_MAINACTIVITY);
        ARouter.getInstance().build(ConstantLoginArouter.PATH_COMMON_LOGINACTIVITY)//指定跳到那个页面
                .withString("targetUrl", ConstantLoginArouter.PATH_APP_MAINACTIVITY)//传入目标页面路由地址  可以在指定页面跳入到目标页面
                .navigation();

//        进阶用法
//        Uri testUriMix = Uri.parse("router://com.senon.firstmoduel/firstmoduel/firstmainactivity");
//        ARouter.getInstance().build(testUriMix)
//                .withString("key1", "value1")
//                .navigation();
    }

    public void toB(View view){
//        ARouter.getInstance().build(ConstantArouter.PATH_APP_FRAGMENTHOMEACTIVITY)
//                .navigation();
    }
}

