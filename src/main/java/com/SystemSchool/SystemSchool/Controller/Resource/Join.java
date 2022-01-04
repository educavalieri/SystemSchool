package com.SystemSchool.SystemSchool.Controller.Resource;

import com.SystemSchool.SystemSchool.Controller.DTO.JoinDTO;
import com.SystemSchool.SystemSchool.Model.Entities.Professor;
import com.SystemSchool.SystemSchool.Model.Entities.Student;
import com.SystemSchool.SystemSchool.Service.Implement.ProfessorServiceIMP;
import com.SystemSchool.SystemSchool.Service.Implement.StudentServiceIMP;
import com.SystemSchool.SystemSchool.Service.Interface.ProfessorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/join")
public class Join {

    @Autowired
    private ProfessorServiceIMP professorServiceIMP;

    @Autowired
    private StudentServiceIMP studentServiceIMP;

    @RequestMapping("/index")
    public ModelAndView joinPage(){
        ModelAndView mv = new ModelAndView("join");
        Iterable<Student> students = studentServiceIMP.findAllStudent();
        mv.addObject("students", students);
        return mv;
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity joinTables(@RequestBody JoinDTO dto){
        System.out.println(dto.getProf_id());
        System.out.println(dto.getStud_id());
        System.out.println(dto.getGrade());
        Student student = studentServiceIMP.findByID(dto.getStud_id()).orElse(null);
        Professor professor = professorServiceIMP.findById(dto.getProf_id());
        System.out.println(professor);
        System.out.println(student);
        professor.getStudents().add(student);

        try {
            professorServiceIMP.saveProfessor(professor);
            System.out.println("join ok");
            return ResponseEntity.ok().body(professor);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "findjoinProfessor{id}", method = RequestMethod.GET)
    public List findJoinProfessor(@PathVariable("id") Integer id){
        Professor professor = professorServiceIMP.findById(id);
        Optional<Professor> test = Optional.ofNullable(professor);
        if(!test.isPresent()){
            throw new RuntimeException("Professor doesn't find");
        }
        System.out.println(test);
        List list = Arrays.asList(professor.getStudents().toArray());
        return list;
    }

    @RequestMapping(value = "findjoinStudent{id}", method = RequestMethod.GET)
    public List findJoinStudent(@PathVariable("id") Integer id){
        Student student = studentServiceIMP.findByID(id).orElse(null);
        Optional<Student> test = Optional.ofNullable(student);
        if(!test.isPresent()){
            throw new RuntimeException("Student doesn't find");
        }
        List list = Arrays.asList(student.getProfessors().toArray());
        return list;

    }



}
