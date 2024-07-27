package com.mukit.springbootscheduler.service.impl;

import com.mukit.springbootscheduler.entity.Student;
import com.mukit.springbootscheduler.enums.StudentStatus;
import com.mukit.springbootscheduler.repository.StudentRepository;
import com.mukit.springbootscheduler.service.StudentService;
import com.mukit.springbootscheduler.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllEligibleStudents() {
        List<Student> eligibleStudents = new ArrayList<>();
        try {
            long waitTime = 10 * 60 * 1000;
            long startTime = DateUtils.getStartOfDayEpoch(0);
            long uptoTime = DateUtils.currentTimeInMillis() - waitTime;

            eligibleStudents = studentRepository.findByStatusAndCreatedDateBetween(StudentStatus.PENDING.name(), startTime, uptoTime);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }

        return eligibleStudents;
    }
}
