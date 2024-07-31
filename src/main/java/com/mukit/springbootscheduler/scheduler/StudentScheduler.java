package com.mukit.springbootscheduler.scheduler;


import com.mukit.springbootscheduler.service.StudentService;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StudentScheduler {

    private static final Logger log = LoggerFactory.getLogger(StudentScheduler.class);

    private final StudentService studentService;

    public StudentScheduler(StudentService studentService) {
        this.studentService = studentService;
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void doTask() {
        log.info("Scheduler Started .........");
        studentService.resolve();
    }
}
