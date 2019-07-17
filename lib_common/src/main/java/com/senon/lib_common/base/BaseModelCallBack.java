package com.senon.lib_common.base;


public interface BaseModelCallBack<T> {

    void onNext(T t);

    void onError(Throwable e);

}
