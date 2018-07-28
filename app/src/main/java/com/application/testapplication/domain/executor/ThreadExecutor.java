
package com.application.testapplication.domain.executor;


import io.reactivex.Scheduler;

public interface ThreadExecutor {

    Scheduler getScheduler();
}
