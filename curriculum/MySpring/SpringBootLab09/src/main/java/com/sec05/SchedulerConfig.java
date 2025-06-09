package com.sec05;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

	//Custom thread pool adjustment
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler my_s = new ThreadPoolTaskScheduler();
		my_s.setPoolSize(5); // register 5 threads
		my_s.setThreadNamePrefix("My-");
		my_s.initialize();
		taskRegistrar.setTaskScheduler(my_s);
		
	}
	
}
