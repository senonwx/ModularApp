package com.senon.lib_common.common.ui;

import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.senon.lib_common.ConstantArouter;
import com.senon.lib_common.R;
import com.senon.lib_common.base.BaseActivity;
import com.senon.lib_common.base.BaseResponse;
import com.senon.lib_common.bean.Chapter;
import com.senon.lib_common.common.contract.ModelRequestContract;
import com.senon.lib_common.common.presenter.ModelRequestPresenter;
import com.senon.lib_common.utils.ComUtil;
import com.senon.lib_common.utils.StatusBarUtils;

import java.util.List;

/**
 * 结合model层请求数据
 */
@Route(path = ConstantArouter.PATH_MODELREQUESTACTIVITY)
public class ModelRequestActivity extends BaseActivity<ModelRequestContract.View, ModelRequestContract.Presenter> implements
        ModelRequestContract.View {

    private TextView tv;

    @Override
    public int getLayoutId() {
        StatusBarUtils.with(this).init();
        return R.layout.common_activity_modelrequest;
    }

    @Override
    public ModelRequestContract.Presenter createPresenter() {
        return new ModelRequestPresenter(this);
    }

    @Override
    public ModelRequestContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        ComUtil.changeStatusBarTextColor(this,true);

        tv = findViewById(R.id.tv);

    }

    public void onClick(View view){
        getPresenter().getData(true,true);
    }

    @Override
    public void getDataResult(BaseResponse<List<Chapter>> data) {
        tv.setText(data.getData().toString());
    }


}
