package com.example.myapp.network;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ryan on 16/04/2019.
 */
public class RetrofitHelper {
    private static ZhihuApi zhihuApi;
    private static OkHttpClient okHttpClient = HttpConfig.getOkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory =
            RxJava2CallAdapterFactory.create();

    public static ZhihuApi getDouBanApi() {
        if (zhihuApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(API.ZHIHU_BASE_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            zhihuApi = retrofit.create(ZhihuApi.class);
        }
        return zhihuApi;
    }
}
