package com.bancodelcomercio.retopractico.data.datasource.cloud.apiclient;

import com.bancodelcomercio.retopractico.presentation.utils.Constants;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    public static ApiInterface getApiClient() {

        String url;
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(1);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
             //   .addInterceptor(new BasicAuthInterceptor("Bearer " + token))
                .addNetworkInterceptor(new StethoInterceptor())
                //     .authenticator(tokenAuthenticator)
                .build();

        url = Constants.URLS.URL_BASE;
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //   }
        return retrofit.create(ApiInterface.class);
    }


}
