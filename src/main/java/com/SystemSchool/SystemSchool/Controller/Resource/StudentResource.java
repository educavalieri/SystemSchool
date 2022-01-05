package com.SystemSchool.SystemSchool.Controller.Resource;

import com.SystemSchool.SystemSchool.Model.Entities.Student;
import com.SystemSchool.SystemSchool.Service.Implement.StudentServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")

public class StudentResource {

    @Autowired
    private StudentServiceIMP studentServiceIMP;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView loadStudentView(){
        ModelAndView mv = new ModelAndView("student/student");
        return mv;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView loadStudentInformationView(Integer student_id){
        ModelAndView result = loadStudentInformationResult(student_id);
        return result;
    }


    @RequestMapping(value = "/student{id}", method = RequestMethod.GET)
    public ModelAndView loadStudentInformationResult(@PathVariable("id") Integer id){
        System.out.println(id);
        ModelAndView mv = new ModelAndView("/student/studentResult");
        Student student = studentServiceIMP.findByID(id).orElse(null);
        System.out.println(student);
        mv.addObject("students", student);
        return mv;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ResponseEntity<Student> saveStudent(@RequestBody Student student){
        System.out.println(student.hashCode());

        try {
            Student response = studentServiceIMP.saveStudent(student);
            return new  ResponseEntity( response,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(student);
        }

    }
    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    List<Student> viewIdStudent(Integer id){
        return studentServiceIMP.findAllStudent();

    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    ResponseEntity deleteStudent(@PathVariable("id") Integer id){
        Optional<Student> student = studentServiceIMP.findByID(id);
        if(!student.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        studentServiceIMP.deleteStudent(id);
        return ResponseEntity.ok().body("user deleted");
    }

}
