package com.application.testapplication.injection.module;

import com.application.testapplication.ui.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {

    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();
}
