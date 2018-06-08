package com.example.matsayya.ihorizonsdemo.di.components;


import android.content.Context;


import com.example.matsayya.ihorizonsdemo.di.module.CommonApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = CommonApplicationModule.class)
@Singleton
public interface CommonApplicationComponent {
   // void applyInjction(CommonApplication application);

    Retrofit exposeRetrofit();
    Context exposeContext();

}
