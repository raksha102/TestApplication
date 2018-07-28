package com.application.testapplication.injection.module;

import com.application.testapplication.injection.scope.ActivityScope;
import com.application.testapplication.ui.MIVIActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {BaseModule.class, LoginModule.class, HomeModule.class})
    abstract MIVIActivity bindBaseActivity();
}
