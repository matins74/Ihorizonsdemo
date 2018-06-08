package com.example.matsayya.ihorizonsdemo.di.module;



import com.example.matsayya.ihorizonsdemo.api.CommonApiService;
import com.example.matsayya.ihorizonsdemo.di.scope.PerActivity;
import com.example.matsayya.ihorizonsdemo.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    private MainView mainView;
   // private LoginView mainView;


    public MainModule(MainView view)
    {
        mainView = view;
    }

    @PerActivity
    @Provides
    CommonApiService provideApiService(Retrofit retrofit)
    {
        return retrofit.create(CommonApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideMainView()
    {
        return mainView;
    }
}
