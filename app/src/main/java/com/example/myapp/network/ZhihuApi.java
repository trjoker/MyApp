package com.example.myapp.network;

import com.example.myapp.bean.DailyNews;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ryan on 19/04/2019.
 */
public interface ZhihuApi {

    //获取某天的新闻
    @GET("4/news/before/{date}")
    Observable<DailyNews> getDaily(@Path("date") String date);
}
