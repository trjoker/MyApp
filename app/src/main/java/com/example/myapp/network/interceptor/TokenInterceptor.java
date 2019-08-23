package com.example.myapp.network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ryan on 24/04/2019.
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        //token过期
//        if (response shows expired token) {
//
//            // get a new token (I use a synchronous Retrofit call)
//
//            // create a new request and modify it accordingly using the new token
//            Request newRequest = request.newBuilder()...build();
//
//            // retry the request
//            return chain.proceed(newRequest);
//        }
//        if(token 过期){
//            if(access token 过期){
//                请求access token(){
//                    new callback(
//                            new success(){
//                                保存新token重新请求
//                                Request newRequest = request.newBuilder()
//                                        .removeHeader("旧的token")   //移除旧的token
//                                        .header("旧的token", new_token)  //添加新的token
//                                        .build();
//                            },
//                            new error(){
//                                重新登录
//                            }
//                    );
//
//                }
//            }else{
//                重新登录
//            }
//        }



        return response;
    }
}
