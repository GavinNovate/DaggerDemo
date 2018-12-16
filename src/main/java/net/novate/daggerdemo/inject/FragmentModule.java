package net.novate.daggerdemo.inject;

import net.novate.daggerdemo.view.fragment.InsertFragment;
import net.novate.daggerdemo.view.fragment.UserFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentModule {

    @ContributesAndroidInjector
    InsertFragment contributesInsertFragment();

    @ContributesAndroidInjector
    UserFragment contributesUserFragment();
}
