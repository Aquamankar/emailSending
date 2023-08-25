package com.sendingemails.service;

import com.sendingemails.entity.Student;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(Long id);
//    void sendStudentEmail(Long id);
}