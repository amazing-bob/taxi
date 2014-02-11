package com.taxi.util.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.taxi.services.quartz.QuartzServiceImpl;

public class JobQuartz extends QuartzJobBean {

    private QuartzServiceImpl quartzService;

	  public JobQuartz(){}

	  @Async
	  protected void executeInternal(JobExecutionContext ctx)
			  									throws JobExecutionException {

		  quartzService = (QuartzServiceImpl)ctx.getJobDetail()
				  										.getJobDataMap()
				  												.get("quartzService");

		  try {
			  if (ctx.getTrigger().getClass().getCanonicalName()
					  	.equals("org.quartz.impl.triggers.SimpleTriggerImpl")){
				  
				//  quartzService.performService();
				  System.out.println("1");
			  } else {
				  quartzService.roomCheckService();
				  System.out.println("2");
			  }
		  } catch (Exception e) {
				e.printStackTrace();
		  }
	 }
}