package com.redhat.gpe.refarch.bpm_signalling.processtier;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.process.WorkItemHandler;

import org.apache.log4j.Logger;

public class StartWaitState implements WorkItemHandler {

    public static final String P1 = "taskP1";

    private static Logger log = Logger.getLogger("StartWaitState");
    private int ksessionId = 0;

    public StartWaitState(KieSession sessionObj) {
        ksessionId = sessionObj.getId();
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        Integer p1 = 0;
        if(workItem.getParameter(P1) != null)
            p1 = (Integer)workItem.getParameter(P1);
        log.info("executeWorkItem() ksessionId = "+ksessionId+" : pInstanceId = "+workItem.getProcessInstanceId()+" : workItemId = "+workItem.getId()+" : p1 = "+p1 );
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        log.warn("abortWorkItem() ksessionId = "+ksessionId+" : pInstanceId = "+workItem.getProcessInstanceId()+" : workItemId = "+workItem.getId());
    }
}
