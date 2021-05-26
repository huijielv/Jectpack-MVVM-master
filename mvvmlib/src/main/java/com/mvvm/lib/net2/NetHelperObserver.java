package com.mvvm.lib.net2;

import androidx.lifecycle.LifecycleObserver;
import com.mvvm.lib.net.bean.ApiResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class NetHelperObserver <T extends ApiResponse> implements Observer<T>, LifecycleObserver {

    private NetCallback<T> mCallback;

    public NetHelperObserver(NetCallback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

        if (mCallback!=null ){
            mCallback.onStart();
        }

    }

    @Override
    public void onNext(T t) {

        if ( t!=null&&mCallback!=null){
            mCallback.onSuccess(t);
        }

    }

    @Override
    public void onError(Throwable e) {
        if (mCallback!=null){
            mCallback.onFail(e.getMessage());
        }
    }

    @Override
    public void onComplete() {
       if (mCallback!=null){
           mCallback.requestEnd();
       }
    }
}
