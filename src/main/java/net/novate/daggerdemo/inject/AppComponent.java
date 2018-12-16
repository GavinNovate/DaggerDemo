package net.novate.daggerdemo.inject;

import android.app.Application;

import net.novate.daggerdemo.DaggerDemo;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {

    void inject(DaggerDemo daggerDemo);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
