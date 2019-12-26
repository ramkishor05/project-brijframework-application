package org.brijframework.app;

import java.util.concurrent.TimeUnit;

import org.brijframework.atn.task.Task;
import org.brijframework.beans.TaskBean;

public class EOAppTask extends TaskBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String data;
	// user  auto task
	@Task(initialDelay=3,initialDelayUnit=TimeUnit.SECONDS,period=3, periodUnit=TimeUnit.MINUTES)
    public void runSystemTime() {
        System.out.println("Executing Task auto initialDelayUnit");
    }
	
	// user system scheduled task
	@Task(startTime="4:20pm",stopTime="11:25AM")
    public void runTaskData() {
        System.out.println("Executing Task scheduled task");
    }
	
	// user required task
	@Task(startDate="12/12/2016 10:40 AM", stopDate="18/12/2016 10:40 AM")
    public void runUserData() {
        System.out.println("Executing Task default");
    }
	
	@Task(initialDelay=2,period=3)
    public void runSystemTask() {
        System.out.println("Executing Task auto");
    }
}
