package com.mvvm.lib.net.livedata;

import com.mvvm.lib.net.bean.ApiResponse;

public class BaseObserver<T> implements IBaseObserver<T> {

    private BaseObserverCallBack<T> baseObserverCallBack;


    private BaseObserver(BaseObserverCallBack<T> baseObserverCallBack) {
        this.baseObserverCallBack = baseObserverCallBack;
    }


    @Override
    public void onChanged(T t) {

        if (t instanceof ApiResponse) {

            ApiResponse apiResponse = (ApiResponse) t;

            if (apiResponse.isSuccess()) {
                baseObserverCallBack.onSuccess(t);
            } else {
                baseObserverCallBack.onFail(apiResponse.getErrorMsg());
            }

        } else {
            baseObserverCallBack.onFail("系统繁忙!");
        }

        baseObserverCallBack.onFinish();


    }
}
