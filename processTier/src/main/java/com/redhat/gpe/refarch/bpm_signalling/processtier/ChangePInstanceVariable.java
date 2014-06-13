package com.redhat.gpe.refarch.bpm_signalling.processtier;


import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.process.WorkItemHandler;

import org.apache.log4j.Logger;

public class ChangePInstanceVariable implements WorkItemHandler {

    public static final String SLEEP_TIME = "sleep.time";
    public static final String P1 = "p1";

    private static Logger log = Logger.getLogger("ChangePInstanceVariable");
    private int ksessionId = 0;
    private int sleepTime = 0;

    public ChangePInstanceVariable(KieSession sessionObj) {
        ksessionId = sessionObj.getId();
        sleepTime = Integer.parseInt(System.getProperty(SLEEP_TIME, "0L"));
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        Integer p1 = (Integer)workItem.getParameter(P1);
        Long pInstanceId = workItem.getProcessInstanceId();
        p1++;
        log.info("executeWorkItem() pInstanceId = "+pInstanceId+" : ksessionId = "+ksessionId+" : p1 = "+p1);
        Thread.sleep(sleepTime);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
