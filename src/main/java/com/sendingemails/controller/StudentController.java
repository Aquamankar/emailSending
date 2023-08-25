package com.sendingemails.controller;

import com.sendingemails.entity.Student;
import com.sendingemails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/form")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student , Model map) {
        studentService.saveStudent(student);
       map.addAttribute("successMessage", "Record saved successfully!");
        System.out.println("Success message added to the model: " + map.getAttribute("successMessage"));
        return "redirect:/students/form";
    }

//    @GetMapping("/send-email")
//    public String sendEmail(@RequestParam Long studentId) {
//        studentService.sendStudentEmail(studentId);
//        return "redirect:/students/form";
//    }
}
