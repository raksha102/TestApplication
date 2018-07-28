package com.application.testapplication.injection.component;

import android.app.Application;

import com.application.testapplication.application.MIVIApplication;
import com.application.testapplication.injection.module.ActivityBuilderModule;
import com.application.testapplication.injection.module.ApplicationModule;
import com.application.testapplication.injection.module.DataModule;
import com.application.testapplication.injection.scope.ApplicationScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Component(modules = {AndroidInjectionModule.class, ActivityBuilderModule.class, ApplicationModule.class,
        DataModule.class})
public interface ApplicationComponent {

    void inject(MIVIApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
