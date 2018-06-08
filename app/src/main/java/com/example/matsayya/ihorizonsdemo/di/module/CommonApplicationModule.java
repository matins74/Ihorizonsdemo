package com.example.matsayya.ihorizonsdemo.di.module;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;



import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CommonApplicationModule {


    private  String mbaseUrl;
    private Context mContext;

    public CommonApplicationModule(Context context, String baseUrl)
    {
        mbaseUrl = baseUrl;
        mContext = context;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory()
    {
        return GsonConverterFactory.create();

    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory()
    {
        return RxJavaCallAdapterFactory.create();

    }


    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1()
    {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
               // .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient provideOkHttpClient2()
    {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
               // .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory)
    {
        return new Retrofit.Builder().baseUrl(mbaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    Context provideContext()
    {
        return  mContext;
    }
}
