package com.example.matsayya.ihorizonsdemo.di.components;




import com.example.matsayya.ihorizonsdemo.di.module.MainModule;
import com.example.matsayya.ihorizonsdemo.di.scope.PerActivity;
import com.example.matsayya.ihorizonsdemo.modules.home.MainActivity;

import dagger.Component;


@PerActivity
@Component(modules = MainModule.class, dependencies = CommonApplicationComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

   // void injectLogin(LoginActivity loginAcitivity);
}
