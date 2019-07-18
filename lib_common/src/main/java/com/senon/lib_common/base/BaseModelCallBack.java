package com.senon.lib_common.base;


public interface BaseModelCallBack<T> {

    void onNext(T t);

    void onError(Throwable e);

    //数据库读取进度
//    void onProgress(int total,int current,float progress);

}
