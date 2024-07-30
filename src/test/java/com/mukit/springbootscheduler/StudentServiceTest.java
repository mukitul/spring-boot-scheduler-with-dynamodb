package com.mukit.springbootscheduler;

import com.mukit.springbootscheduler.entity.Student;
import com.mukit.springbootscheduler.enums.StudentStatus;
import com.mukit.springbootscheduler.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test_findEligibleStudent() {
        studentService.findAllEligibleStudents();
    }

    @Test
    public void test_save() {
        Student student = Student.builder()
                .studentId("std-1234")
                .name("std-name")
                .age(20)
                .email("std@email.com")
                .status(StudentStatus.ACTIVE.name())
                .build();
        studentService.save(student);
    }
}
