package net.novate.daggerdemo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import net.novate.daggerdemo.model.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    @NonNull
    public static AppDatabase create(@NonNull Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "dagger.db").build();
    }

    public abstract UserDao userDao();
}
