package net.novate.daggerdemo.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import net.novate.daggerdemo.model.User;

@Dao
public interface UserDao {
    @Insert
    long[] insert(User... users);

    @Delete
    int delete(User... users);

    @Update
    int update(User... users);

    @Query("SELECT * FROM User WHERE name LIKE '%'||:name||'%' AND phone LIKE '%'||:phone||'%'")
    User[] findByNameAndPhone(String name, String phone);

    @Query("SELECT * FROM User")
    LiveData<User[]> observeAll();

    @Query("SELECT * FROM User WHERE name LIKE '%'||:name||'%' AND phone LIKE '%'||:phone||'%'")
    LiveData<User[]> observeByNameAndPhone(String name, String phone);
}
