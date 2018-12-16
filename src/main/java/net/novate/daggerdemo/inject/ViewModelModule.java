package net.novate.daggerdemo.inject;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import net.novate.daggerdemo.viewmodel.UserViewModel;
import net.novate.daggerdemo.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    ViewModel bindUserViewModel(UserViewModel viewModel);

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
