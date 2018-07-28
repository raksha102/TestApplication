package com.application.testapplication.injection.module;

import com.application.testapplication.injection.scope.ActivityScope;
import com.application.testapplication.ui.login.LoginFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {

    @ContributesAndroidInjector
    abstract LoginFragment bindLoginFragment();
}
