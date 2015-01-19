/*
 * Copyright 2010 - Organization for Free and Open Source Software,  
 *                 Athens, Greece.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials provided
 *       with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package eu.sqooss.service.admin.actions;

import eu.sqooss.core.AlitheiaCore;
import eu.sqooss.service.admin.AdminActionBase;
import eu.sqooss.service.scheduler.SchedulerStats;

public class RunTimeInfo extends AdminActionBase {

    public static final String MNEMONIC = "rti";
    private static final String descr = "Returns misc runtime information";

    public RunTimeInfo() {
        super();
    }

    @Override
    public String mnemonic() {
        return MNEMONIC;
    }

    @Override
    public String descr() {
        return descr;
    }

    @Override
    public void execute() throws Exception {
        super.execute();
        
        SchedulerStats schedulerStats = getSchedulerStats();
        schedulerStats.statsForExecute(this);
        finished("Info retrieved");
    }
    
    public SchedulerStats getSchedulerStats() {
    	SchedulerStats schedulerStats = AlitheiaCore.getInstance().getScheduler().getSchedulerStats();
    	return schedulerStats;
    }
}
