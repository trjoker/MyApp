package com.example.myapp.network.authenticator;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by Ryan on 24/04/2019.
 */
public class TokenAuthenticator implements Authenticator {
    @Override
    public Request authenticate(Route route, Response response) throws IOException {


//        newAccessToken = service.refreshToken();
//        // Add new header to rejected request and retry it
//        return response.request().newBuilder()
//                .header(AUTHORIZATION, newAccessToken)
//                .build();

        return null;
    }
}
