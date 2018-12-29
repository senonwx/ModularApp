package com.senon.lib_common;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储各个主模块首页的路由地址：判断是哪个模块登录的
 * 当然也可以不用单独从ConstantArouter分离出这些主页地址，看个人喜好
 */
public class ConstantLoginArouter {

    public static Map<String, String> activityRouterMap = new HashMap<>();

    //app主页
    public static final String PATH_APP_MAINACTIVITY = "/app/MainActivity";

    //one主页
    public static final String PATH_ONE_MAINACTIVITY = "/one/OneMainActivity";
    //two首页
    public static final String PATH_TWO_MAINACTIVITY = "/life/TwoMainActivity";

    //登录 注册
    public static final String PATH_COMMON_LOGINACTIVITY = "/lib_common/LoginActivity";

    static {
        activityRouterMap.put(getActivityName(PATH_COMMON_LOGINACTIVITY), PATH_COMMON_LOGINACTIVITY);

        activityRouterMap.put(getActivityName(PATH_APP_MAINACTIVITY), PATH_APP_MAINACTIVITY);
        activityRouterMap.put(getActivityName(PATH_ONE_MAINACTIVITY), PATH_ONE_MAINACTIVITY);
        activityRouterMap.put(getActivityName(PATH_TWO_MAINACTIVITY), PATH_TWO_MAINACTIVITY);
    }

    private static String getActivityName(String routerUrl) {
        int pos = routerUrl.lastIndexOf("/");
        return routerUrl.substring(pos + 1);
    }

    public static String getCurRouter(String activityName) {
        return activityRouterMap.get(activityName);
    }
}
