package com.mukit.springbootscheduler.scheduler;


import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StudentScheduler {

    private static final Logger log = LoggerFactory.getLogger(StudentScheduler.class);

    @Scheduled(cron = "*/2 * * * * ?")
    @SchedulerLock(name = "StudentScheduler_doTask", lockAtLeastFor = "PT10S", lockAtMostFor = "PT10S")
    public void doTask() {
        log.info("running...");
    }
}
