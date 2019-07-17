package com.senon.lib_common.common.model;

import android.content.Context;
import com.senon.lib_common.base.BaseResponse;
import com.senon.lib_common.bean.Chapter;
import com.senon.lib_common.bean.Login;
import com.senon.lib_common.common.contract.ModelRequestContract;
import com.senon.lib_common.base.BaseModelCallBack;
import com.senon.lib_common.net.ServerUtils;
import com.senon.lib_common.net.callback.RequestCallback;
import com.senon.lib_common.net.callback.RxErrorHandler;
import com.senon.lib_common.utils.RetryWithDelay;
import com.senon.lib_common.utils.RxUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.List;
import java.util.Map;

/**
 * model
 */
public class ModelRequestMod implements ModelRequestContract.Model {

    @Override
    public void getData(LifecycleTransformer<BaseResponse<List<Chapter>>> transformer, Context context,
                        boolean isDialog, boolean cancelable, final BaseModelCallBack callBack){
        ServerUtils.getCommonApi().getChapters()
                .retryWhen(new RetryWithDelay(3,2))
                .compose(transformer)
                .compose(RxUtils.<BaseResponse<List<Chapter>>>getSchedulerTransformer())
                .subscribe(new RequestCallback<BaseResponse<List<Chapter>>>(context, RxErrorHandler.getInstance(),isDialog,cancelable) {
                    @Override
                    public void onNext(BaseResponse<List<Chapter>> response) {
                        super.onNext(response);
                        callBack.onNext(response);
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        callBack.onError(e);
                    }
                });
    }



}
