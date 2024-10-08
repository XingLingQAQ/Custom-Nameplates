/*
 *  Copyright (C) <2024> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customnameplates.common.plugin.scheduler;

import java.util.concurrent.ScheduledFuture;

public class AsyncTask implements SchedulerTask {

    private final ScheduledFuture<?> future;

    public AsyncTask(ScheduledFuture<?> future) {
        this.future = future;
    }

    @Override
    public void cancel() {
        future.cancel(false);
    }

    @Override
    public boolean cancelled() {
        return future.isCancelled();
    }
}
