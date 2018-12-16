package net.novate.daggerdemo.repository;

import android.arch.lifecycle.LiveData;

import net.novate.daggerdemo.database.UserDao;
import net.novate.daggerdemo.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@Singleton
public class UserRepository {

    @Inject
    public UserDao userDao;

    @Inject
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public Observable<long[]> insert(User... users) {
        return Observable.create((ObservableOnSubscribe<long[]>) emitter -> {
            emitter.onNext(userDao.insert(users));
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public LiveData<User[]> observeAll() {
        return userDao.observeAll();
    }
}
