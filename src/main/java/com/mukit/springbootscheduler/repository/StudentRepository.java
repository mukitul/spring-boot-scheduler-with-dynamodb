package com.mukit.springbootscheduler.repository;

import com.mukit.springbootscheduler.entity.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, String> {
    List<Student> findByStatusAndCreatedDateBetween(String status, Long startDate, Long endDate);
}
