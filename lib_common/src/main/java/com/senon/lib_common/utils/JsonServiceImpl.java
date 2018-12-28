package com.senon.lib_common.utils;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;
import java.lang.reflect.Type;


// 如果需要传递自定义对象，新建一个类（并非自定义对象类），然后实现 SerializationService,
// 并使用@Route注解标注(方便用户自行选择序列化方式)，例如：
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {

    private Gson mGson;

    @Override
    public void init(Context context) {
        mGson = new Gson();

    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        checkJson();
        return mGson.fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        checkJson();
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        checkJson();
        return mGson.fromJson(input, clazz);
    }

    public void checkJson() {
        if (mGson == null) {
            mGson = new Gson();
        }
    }
}

