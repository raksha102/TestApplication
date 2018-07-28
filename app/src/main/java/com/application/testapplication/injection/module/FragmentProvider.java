package com.application.testapplication.injection.module;

import com.application.testapplication.ui.home.HomeScreenFragment;
import com.application.testapplication.ui.home.SplashScreenFragment;
import com.application.testapplication.ui.login.LoginFragment;

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
