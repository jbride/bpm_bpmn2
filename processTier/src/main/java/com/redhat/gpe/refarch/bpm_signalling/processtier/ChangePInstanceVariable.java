package com.redhat.gpe.refarch.bpm_signalling.processtier;


import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.process.WorkItemHandler;

import org.apache.log4j.Logger;

public class ChangePInstanceVariable implements WorkItemHandler {

    public static final String SLEEP_TIME = "sleepTime";
    public static final String P1 = "taskP1";

    private static Logger log = Logger.getLogger("ChangePInstanceVariable");
    private int ksessionId = 0;

    public ChangePInstanceVariable(KieSession sessionObj) {
        ksessionId = sessionObj.getId();
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        Integer p1 = (Integer)workItem.getParameter(P1);
        Integer sleepTime = Integer.parseInt((String)workItem.getParameter(SLEEP_TIME));
        Long pInstanceId = workItem.getProcessInstanceId();
        p1++;
        log.info("executeWorkItem() pInstanceId = "+pInstanceId+" : ksessionId = "+ksessionId+" : p1 = "+p1+" : sleepTime = "+sleepTime);
        try {
            Thread.sleep(sleepTime);
        }catch(Exception x) {
            throw new RuntimeException(x);
        }
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
