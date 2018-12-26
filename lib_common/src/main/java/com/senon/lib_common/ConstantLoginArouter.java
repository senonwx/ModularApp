package com.senon.lib_common;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储各个主模块登录的路由地址：判断是哪个模块登录的
 */
public class ConstantLoginArouter {

    public static Map<String, String> activityRouterMap = new HashMap<>();

    //app主页
    public static final String PATH_APP_MAINACTIVITY = "/app/MainActivity";

    //home主页
    public static final String PATH_HOME_MAINACTIVITY = "/home/HomeMainActivity";
    //Life首页
    public static final String PATH_LIFE_MAINACTIVITY = "/life/LifeMainActivity";

    //登录 注册
    public static final String PATH_COMMON_LOGINACTIVITY = "/lib_common/LoginActivity";

    static {
        activityRouterMap.put(getActivityName(PATH_COMMON_LOGINACTIVITY), PATH_COMMON_LOGINACTIVITY);

        activityRouterMap.put(getActivityName(PATH_APP_MAINACTIVITY), PATH_APP_MAINACTIVITY);
        activityRouterMap.put(getActivityName(PATH_HOME_MAINACTIVITY), PATH_HOME_MAINACTIVITY);
        activityRouterMap.put(getActivityName(PATH_LIFE_MAINACTIVITY), PATH_LIFE_MAINACTIVITY);
    }

    private static String getActivityName(String routerUrl) {
        int pos = routerUrl.lastIndexOf("/");
        return routerUrl.substring(pos + 1);
    }

    public static String getCurRouter(String activityName) {
        return activityRouterMap.get(activityName);
    }
}
