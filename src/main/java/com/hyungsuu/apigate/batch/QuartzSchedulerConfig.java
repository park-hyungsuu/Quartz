package com.hyungsuu.apigate.batch;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzSchedulerConfig {

    @Bean
    public JobDetail firstJobDetail() {
        return JobBuilder.newJob(FirstJob.class)
                .withIdentity("FirstJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger firstJobTrigger(JobDetail firstJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(firstJobDetail)
                .withIdentity("FirstJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("2 * * * * ?"))
//                .withSchedule(SimpleScheduleBuilder.repeatHourlyForever())
                .build();
    }

    @Bean
    public JobDetail secondJobDetail() {
    	return JobBuilder.newJob(SecondJob.class)
                .withIdentity("SecondJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger secondJobTrigger(JobDetail secondJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(secondJobDetail)
                .withIdentity("SecondJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("5 * * * * ?"))
                .build();
    }
}