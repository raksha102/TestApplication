/*
 *  Copyright © 2018, Cognizant Technology Solutions.
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.application.testapplication.application;


import com.application.testapplication.domain.executor.ThreadExecutor;
import com.application.testapplication.injection.scope.ApplicationScope;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * MainThread (IO Thread) implementation based on a {@link Scheduler}
 * which will execute actions on the Android IO thread
 */
@ApplicationScope
public class IOThread implements ThreadExecutor {

    @Inject
    public IOThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
