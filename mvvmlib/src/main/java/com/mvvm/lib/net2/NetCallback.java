package com.mvvm.lib.net2;

import com.mvvm.lib.net.bean.ApiResponse;

public interface NetCallback<T extends ApiResponse> {

    void onStart();

    void onSuccess(T response);

    void onFail(String msg);

    void requestEnd();
}
