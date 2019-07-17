package com.senon.lib_common.api;

import com.senon.lib_common.base.BaseResponse;
import com.senon.lib_common.bean.Chapter;
import com.senon.lib_common.bean.Login;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 网络请求接口
 */
public interface BaseApi {


    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<Login>> login(@FieldMap Map<String, String> map);
    //登出
    @GET("user/logout/json")
    Observable<BaseResponse> logout();
    //注册
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<Login>> register(@FieldMap Map<String, String> map);

    //获取公众号文章
    @GET("wxarticle/chapters/json  ")
    Observable<BaseResponse<List<Chapter>>> getChapters();
}
