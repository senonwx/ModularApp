package com.senon.modularapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.senon.lib_common.ConstantArouter;
import com.senon.lib_common.ConstantLoginArouter;
import com.senon.lib_common.adapter.CommonAdapter;
import com.senon.lib_common.adapter.CommonHolder;
import com.senon.lib_common.utils.ComUtil;
import com.senon.lib_common.utils.StatusBarUtils;
import java.util.ArrayList;
import java.util.Map;

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
        ComUtil.changeStatusBarTextColor(this,true);

    }

    public void toA(View view){
//        应用内简单的跳转
//        String curUrl = ConstantLoginArouter.getCurRouter(this.getClass().getSimpleName());
//        String curUrl = ConstantLoginArouter.getCurRouter(ConstantLoginArouter.PATH_HOME_MAINACTIVITY);
//        ARouter.getInstance().build(ConstantLoginArouter.PATH_COMMON_LOGINACTIVITY)//指定跳到那个页面
//                .withString("targetUrl", ConstantLoginArouter.PATH_APP_MAINACTIVITY)//传入目标页面路由地址  可以在指定页面跳入到目标页面
//                .navigation();

        showPopwindow(view,ConstantLoginArouter.PATH_COMMON_LOGINACTIVITY);

//        进阶用法
//        Uri testUriMix = Uri.parse("router://com.senon.firstmoduel/firstmoduel/firstmainactivity");
//        ARouter.getInstance().build(testUriMix)
//                .withString("key1", "value1")
//                .navigation();
    }

    public void toB(View view){
        showPopwindow(view,null);
    }

    private void showPopwindow(View v,final String gotoUrl){
        View view = LayoutInflater.from(this).inflate(R.layout.pop_test,null);
        final PopupWindow pop = new PopupWindow(view,WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        ListView lv = view.findViewById(R.id.pop_lv);
        lv.setAdapter(new CommonAdapter<String>(this,getData(),R.layout.pop_item) {
            @Override
            public void convert(CommonHolder helper, final String item, final int position) {
                helper.setText(R.id.item_tv,position==0?item:item.substring(item.lastIndexOf("/") + 1));
                helper.setOnClickListener(R.id.item_tv,new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(position == 0){
                            return;
                        }
                        if(gotoUrl == null){
                            ARouter.getInstance().build(item)
                                    .navigation();
                        }else{
                            ARouter.getInstance().build(gotoUrl)//指定跳到那个页面
                                    .withString("targetUrl",item)//传入目标页面路由地址  可以在指定页面跳入到目标页面
                                    .navigation();
                        }
                        pop.dismiss();
                    }
                });
            }
        });
        //（注意一下！！）如果不设置popupWindow的背景，无论是点击外部区域还是Back键都无法
        pop.setBackgroundDrawable(null);
        //点击外部收起
        pop.setOutsideTouchable(true);

        pop.showAsDropDown(v);

    }

    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : ConstantLoginArouter.activityRouterMap.entrySet()) {
            if(entry.getValue().contains(ConstantLoginArouter.PATH_COMMON_LOGINACTIVITY)){
                continue;
            }
            list.add(entry.getValue());
        }
        list.add(0,"选择目标页面");
        return list;
    }

    public void modelRequest(View view) {
        ARouter.getInstance().build(ConstantArouter.PATH_MODELREQUESTACTIVITY)//指定跳到那个页面
                .navigation();
    }

}

