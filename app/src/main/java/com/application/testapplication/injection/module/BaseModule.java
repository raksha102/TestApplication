package com.application.testapplication.injection.module;

import android.content.Context;

import com.application.testapplication.injection.scope.ActivityContext;
import com.application.testapplication.injection.scope.ContainerId;
import com.application.testapplication.ui.MIVIActivity;
import com.application.testapplication.ui.base.BaseActivity;
import com.application.testapplication.ui.base.navigator.AppNavigator;
import com.application.testapplication.ui.base.navigator.AppNavigatorImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {BaseModule.Declaration.class})
public class BaseModule {

    @Provides
    @ContainerId
    public int provideContainerId(BaseActivity activity) {
        return activity.getContainerId();
    }

    @Module
    public interface Declaration {

        @Binds
        BaseActivity bindsBaseActivity(MIVIActivity activity);

        @Binds
        @ActivityContext
        Context bindsContext(MIVIActivity activity);

        @Binds
        AppNavigator bindsAppNavigator(AppNavigatorImpl appNavigator);
    }

}
