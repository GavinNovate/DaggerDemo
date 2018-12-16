package net.novate.daggerdemo.inject;

import android.support.annotation.NonNull;

import net.novate.daggerdemo.database.AppDatabase;
import net.novate.daggerdemo.database.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class DatabaseModule {

    @Singleton
    @Provides
    @NonNull
    UserDao provideUserDao(@NonNull AppDatabase database) {
        return database.userDao();
    }
}
