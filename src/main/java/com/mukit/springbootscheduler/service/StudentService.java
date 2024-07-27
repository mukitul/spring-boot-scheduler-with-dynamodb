package com.mukit.springbootscheduler.service;

import com.mukit.springbootscheduler.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllEligibleStudents();
}
