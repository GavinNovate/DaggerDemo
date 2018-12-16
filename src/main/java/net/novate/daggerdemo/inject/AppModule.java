package net.novate.daggerdemo.inject;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import net.novate.daggerdemo.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DatabaseModule.class, ViewModelModule.class})
class AppModule {

    @Singleton
    @Provides
    @NonNull
    Context provideContext(@NonNull Application application) {
        return application;
    }

    @Singleton
    @Provides
    @NonNull
    AppDatabase provideAppDatabase(@NonNull Context context) {
        return AppDatabase.create(context);
    }
}
