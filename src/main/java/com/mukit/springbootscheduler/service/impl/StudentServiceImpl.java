package com.mukit.springbootscheduler.service.impl;

import com.mukit.springbootscheduler.entity.KeyValueEntity;
import com.mukit.springbootscheduler.repository.KeyValueRedisRepository;
import com.mukit.springbootscheduler.service.StudentService;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final KeyValueRedisRepository keyValueRedisRepository;
//    private final StudentRepository studentRepository;

    @Override
//    @SchedulerLock(name = "StudentScheduler_doTask", lockAtLeastFor = "PT10S", lockAtMostFor = "PT10S")
    public void resolve() {
//        log.info("............ Dispute Resolving ................");
    }

//    public void save(Student student) {
//        try {
//            studentRepository.save(student);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//
//    public List<Student> findAllEligibleStudents() {
//        List<Student> eligibleStudents = new ArrayList<>();
//        try {
//            long waitTime = 10 * 60 * 1000;
//            long startTime = DateUtils.getStartOfDayEpoch(0);
//            long uptoTime = DateUtils.currentTimeInMillis() - waitTime;
//
//            eligibleStudents = studentRepository.findByStatusAndCreatedDateBetween(StudentStatus.PENDING.name(), startTime, uptoTime);
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//        }
//
//        return eligibleStudents;
//    }

    public void saveInRedis() {
        KeyValueEntity keyValueEntity = KeyValueEntity.builder()
                .key("1234")
                .value("test")
                .build();

        keyValueRedisRepository.save(keyValueEntity);

    }

    public void getFromRedis() {
        String s = keyValueRedisRepository.get("1234");
        log.info(s);
    }
}
