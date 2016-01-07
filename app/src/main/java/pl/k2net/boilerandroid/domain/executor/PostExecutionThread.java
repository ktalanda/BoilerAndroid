package pl.k2net.boilerandroid.domain.executor;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}