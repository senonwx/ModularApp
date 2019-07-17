package com.senon.lib_common;

/**
 * 所有模块均依赖commonmoduel  所以路由跳转均写入本Constant方便调用
 * 常量类
 * 其中: 路由跳转命名统一用：path+模块名+Activity名
 */
public class ConstantArouter {

    /**
     * App 模块
     */
    public static final String PATH_APP_TESTACTIVITY = "/app/TestActivity";


    /**
     * home 主页
     */
    public static final String PATH_HOME_MAINACTIVITY = "/home/MainActivity";


    /**
     * life 知识体系
     */
    public static final String PATH_LIFE_KNOWLEDGESYSTEMACTIVITY = "/life/KnowledgeSystemActivity";

    /**
     * common
     */
    public static final String PATH_COMMON_REGISTERACTIVITY = "/lib_common/CommonRegisterActivity";
    public static final String PATH_COMMON_WEBVIEWCTIVITY = "/lib_common/CommonWebviewActivity";
    public static final String PATH_MODELREQUESTACTIVITY = "/lib_common/ModelRequestActivity";


}
