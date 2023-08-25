package com.sendingemails.service.impl;

import com.sendingemails.entity.Student;
import com.sendingemails.repository.StudentRepository;
import com.sendingemails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Student saveStudent(Student student) {
        Student save = studentRepository.save(student);
        sendStudentEmail(student.getId());
        return save;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    public void sendStudentEmail(Long id) {
        Student student = getStudentById(id);
        if (student != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(student.getEmail());
            message.setSubject("Student Information");
            message.setText("Hello " + student.getFirstName() + ",\nYour student record has been saved.");
            javaMailSender.send(message);
        }
    }
}
