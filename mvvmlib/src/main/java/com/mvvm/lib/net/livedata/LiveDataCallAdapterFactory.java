package com.mvvm.lib.net.livedata;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.mvvm.lib.net.bean.ApiResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class) {
            return null;
        }

        Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);

        Class<?> rawType = getRawType(observableType);

        boolean isApiResponse = true;

        if (returnType != ApiResponse.class) {
            isApiResponse = false;
        }

        if (!(observableType instanceof ParameterizedType)) {
            Log.e("TAG", "rawType = resource must be parameterized" + rawType.toString());
//            throw new IllegalArgumentException("resource must be parameterized");
        }


        return new LiveDataCallAdapter<String>(observableType, isApiResponse);
    }
}
