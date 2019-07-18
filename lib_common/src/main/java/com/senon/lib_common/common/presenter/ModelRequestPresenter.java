package com.senon.lib_common.common.presenter;

import android.content.Context;

import com.senon.lib_common.base.BaseResponse;
import com.senon.lib_common.bean.Chapter;
import com.senon.lib_common.bean.Login;
import com.senon.lib_common.common.contract.ModelRequestContract;
import com.senon.lib_common.common.model.ModelRequestMod;
import com.senon.lib_common.base.BaseModelCallBack;
import com.senon.lib_common.utils.RxUtils;
import com.senon.lib_common.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;

/**
 * 结合model使用的 p层
 */
public class ModelRequestPresenter extends ModelRequestContract.Presenter {

    private Context context;
    private ModelRequestMod model;

    public ModelRequestPresenter(Context context) {
        this.context = context;
        this.model = new ModelRequestMod();
    }


    @Override
    public void getData(boolean isDialog, boolean cancelable) {
        /**
         * 为什么rx绑定生命周期不放在model层，
         * 因为我们不希望m层拥有直接操作v层的权利 隔离v与m层
         * 只希望m层与p层交互
         */
        model.getData(RxUtils.<BaseResponse<List<Chapter>>>bindToLifecycle(getView()), context, isDialog, cancelable,
                new BaseModelCallBack() {
                    @Override
                    public void onNext(Object o) {
                        getView().getDataResult((BaseResponse<List<Chapter>>) o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.initToast(e.getMessage());
                    }
                });
    }


}
