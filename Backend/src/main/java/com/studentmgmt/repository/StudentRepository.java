package com.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studentmgmt.entity.*;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
