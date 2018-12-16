package net.novate.daggerdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import net.novate.daggerdemo.model.User;
import net.novate.daggerdemo.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends ViewModel {

    @Inject
    public UserRepository userRepository;

    @Inject
    public UserViewModel() {
    }

    //    @Inject
//    public UserViewModel(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public void insert(@NonNull User user) {
        userRepository.insert(user).subscribe(new Observer<long[]>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(long[] longs) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public LiveData<User[]> observeAll() {
        return userRepository.observeAll();
    }
}
