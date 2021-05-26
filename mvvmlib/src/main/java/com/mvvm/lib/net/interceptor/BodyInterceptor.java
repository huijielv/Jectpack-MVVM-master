package com.mvvm.lib.net.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class BodyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String selfID = "";
        String token = "";
        HttpUrl url = originalRequest.url()
                .newBuilder()
                .addQueryParameter("userId", selfID)
                .build();
        Log.e("TAG", "统一参数： " + selfID + "   " + token);
        Request authorised = originalRequest.newBuilder()
                .header("Authorization", selfID + token)
                .url(url)
                .build();

        return chain.proceed(authorised);
    }
}
