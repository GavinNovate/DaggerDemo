package net.novate.daggerdemo.inject;

import net.novate.daggerdemo.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    MainActivity contributeMainActivity();
}
