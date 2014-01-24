package com.taxi.util.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.taxi.services.QuartzServiceImpl;


public class JobQuartz extends QuartzJobBean {

	// 이건 꼭 수정해야 한다....................................... 아래 AS-IS 참고 해서 수정이 필수적임
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
	
	
/*	//====================== AS-IS =======================//
 
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

				  quartzService.performService();

			  } else {
				  quartzService.roomCheckService();
			  }
		  } catch (Exception e) {
				e.printStackTrace();
		  }
	 }
*/
	
}