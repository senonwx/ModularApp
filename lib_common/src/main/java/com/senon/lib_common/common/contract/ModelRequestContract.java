package com.senon.lib_common.common.contract;

import android.content.Context;
import com.senon.lib_common.base.BasePresenter;
import com.senon.lib_common.base.BaseResponse;
import com.senon.lib_common.base.BaseViewImp;
import com.senon.lib_common.bean.Chapter;
import com.senon.lib_common.bean.Login;
import com.senon.lib_common.base.BaseModelCallBack;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.List;
import java.util.Map;

/**
 * ModelRequestContract
 */
public interface ModelRequestContract {

    /**
     * View
     */
    interface View extends BaseViewImp {

        void getDataResult(BaseResponse<List<Chapter>> data);

    }

    /**
     * Presenter
     */
    abstract class Presenter extends BasePresenter<ModelRequestContract.View> {

        public abstract void getData(boolean isDialog, boolean cancelable);

    }

    /**
     * Model
     */
    interface Model{
        void getData(LifecycleTransformer<BaseResponse<List<Chapter>>> transformer, Context context,
                     boolean isDialog, boolean cancelable, BaseModelCallBack callBack);

    }
}
