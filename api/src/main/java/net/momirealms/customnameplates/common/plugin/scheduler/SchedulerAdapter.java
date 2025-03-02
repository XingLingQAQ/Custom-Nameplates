/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package net.momirealms.customnameplates.common.plugin.scheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * A scheduler for running tasks using the systems provided by the platform
 */
public interface SchedulerAdapter<T> {

    /**
     * Gets an async executor instance
     *
     * @return an async executor instance
     */
    Executor async();

    /**
     * Gets a sync executor instance
     *
     * @return a sync executor instance
     */
    RegionExecutor<T> sync();

    /**
     * Executes a task async
     *
     * @param task the task
     */
    default void executeAsync(Runnable task) {
        async().execute(task);
    }

    /**
     * Executes a task sync
     *
     * @param task the task
     * @param location the location
     */
    default void executeSync(Runnable task, T location) {
        sync().run(task, location);
    }

    default void executeSync(Runnable task) {
        sync().run(task, null);
    }

    /**
     * Executes the given task with a delay.
     *
     * @param task the task
     * @param delay the delay
     * @param unit the unit of delay
     * @return the resultant task instance
     */
    SchedulerTask asyncLater(Runnable task, long delay, TimeUnit unit);

    /**
     * Executes the given task repeatedly at a given interval.
     *
     * @param task the task
     * @param delay the delay
     * @param interval the interval
     * @param unit the unit of interval
     * @return the resultant task instance
     */
    SchedulerTask asyncRepeating(Runnable task, long delay, long interval, TimeUnit unit);

    /**
     * Shuts down the scheduler instance.
     *
     * <p>{@link #asyncLater(Runnable, long, TimeUnit)} and {@link #asyncRepeating(Runnable, long, long, TimeUnit)}.</p>
     */
    void shutdownScheduler();

    /**
     * Shuts down the executor instance.
     *
     * <p>{@link #async()} and {@link #executeAsync(Runnable)}.</p>
     */
    void shutdownExecutor();

}
