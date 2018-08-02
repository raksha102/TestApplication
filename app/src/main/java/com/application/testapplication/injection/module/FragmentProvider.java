package com.application.testapplication.injection.module;

import com.application.testapplication.ui.HomeScreenFragment;
import com.application.testapplication.ui.SplashScreenFragment;
import com.application.testapplication.ui.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentProvider {

    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();

    @ContributesAndroidInjector
    abstract SplashScreenFragment bindSplashScreenFragment();

    @ContributesAndroidInjector
    abstract HomeScreenFragment bindHomeScreenFragment();
}
