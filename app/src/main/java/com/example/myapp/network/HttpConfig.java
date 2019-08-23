package com.example.myapp.network;

import android.util.Log;

import com.example.myapp.network.interceptor.HeadRequestInterceptor;
import com.example.myapp.network.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Ryan on 17/04/2019.
 */
public class HttpConfig {public static String TGA = "HttpConfig";
    public static long CONNECT_TIMEOUT = 60L;
    public static long READ_TIMEOUT = 30L;
    public static long WRITE_TIMEOUT = 30L;
    /**
     * 获取OkHttpClient实例
     * @return
     */
    public static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override public void log(String message) {
                Log.d(TGA, "OkHttp: " + message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient   okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
//                .addInterceptor(new HeadRequestInterceptor())
//                .addInterceptor(new LogInterceptor())
                .build();
        return okHttpClient;
    }
}
