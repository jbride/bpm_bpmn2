package com.redhat.gpe.refarch.bpm_signalling.processtier;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.process.WorkItemHandler;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StartWaitState implements WorkItemHandler {

    public static final String P1 = "taskP1";
    public static final String SUB_PROCESS_ID = "sProcessId";

    private static Logger log = LoggerFactory.getLogger("StartWaitState");
    private int ksessionId = 0;
    private KieSession sessionObj = null;

    public StartWaitState(KieSession sessionObj) {
        this.sessionObj = sessionObj;
        ksessionId = sessionObj.getId();
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        Integer p1 = 0;
        if(workItem.getParameter(P1) != null)
            p1 = (Integer)workItem.getParameter(P1);
        ProcessInstance pInstance = sessionObj.getProcessInstance(workItem.getProcessInstanceId());
        log.info("executeWorkItem() pInstance = "+pInstance);
        log.info("executeWorkItem() ksessionId = "+ksessionId+" : pInstanceId = "+workItem.getProcessInstanceId()+" : workItemId = "+workItem.getId()+" : p1 = "+p1 );
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        log.warn("abortWorkItem() ksessionId = "+ksessionId+" : pInstanceId = "+workItem.getProcessInstanceId()+" : workItemId = "+workItem.getId());
    }
}
