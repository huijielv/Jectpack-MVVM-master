package com.mvvm.lib.net.livedata;

import androidx.annotation.NonNull;

import com.mvvm.lib.net.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreateHelp {

    private static final int TIMEOUT_READ = 60;
    private static final int TIMEOUT_CONNECTION = 60;

    private static RetrofitCreateHelp  instance;

    public static RetrofitCreateHelp getInstance() {
        if (instance == null) {
            synchronized (RetrofitCreateHelp .class) {
                instance = new RetrofitCreateHelp ();
            }
        }
        return instance;
    }

    private RetrofitCreateHelp () {
    }


    public <T> T create(String baseURL, Class<T> service) {
        return initRetrofitWithLiveData(baseURL, initOkHttp()).create(service);
    }
    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofitWithLiveData(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseURL)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                .readTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//设置写入超时时间
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                //失败重连
                .retryOnConnectionFailure(true)
//                .cookieJar(getCookieJar())
                .addInterceptor(new LogInterceptor())//添加打印拦截器
                .build();
    }
//    private ClearableCookieJar cookieJar;
//
//    public ClearableCookieJar getCookieJar() {
//        if (cookieJar == null) {
//            cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(AppProvider.getInstance().getApp()));
//        }
//        return cookieJar;
//    }
}
