package com.sendingemails.repository;

import com.sendingemails.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
   Student getStudentById( long id);
}