package com.example.matsayya.ihorizonsdemo.application;

import android.app.Application;

import com.example.matsayya.ihorizonsdemo.di.components.CommonApplicationComponent;
import com.example.matsayya.ihorizonsdemo.di.components.DaggerCommonApplicationComponent;
import com.example.matsayya.ihorizonsdemo.di.module.CommonApplicationModule;


public class CommonApplication extends Application
{

    private CommonApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initialiseApplicationComponent();
    }

    private void initialiseApplicationComponent() {
        applicationComponent = DaggerCommonApplicationComponent.builder().commonApplicationModule(new CommonApplicationModule(this,"https://api.github.com")).build();
    }

    public CommonApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}


// For optical
// http://mysociety360.com