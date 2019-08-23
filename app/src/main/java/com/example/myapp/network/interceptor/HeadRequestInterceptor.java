package com.example.myapp.network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ryan on 17/04/2019.
 */
public class HeadRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request  =  chain.request()
                .newBuilder()
                .addHeader("X-APP-TYPE","android")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}
