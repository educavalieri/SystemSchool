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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
public class Join {

    @Autowired
    private ProfessorServiceIMP professorServiceIMP;

    @Autowired
    private StudentServiceIMP studentServiceIMP;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity joinTables(@RequestBody JoinDTO dto){
        System.out.println(dto.getProf_id());
        System.out.println(dto.getStud_id());
        System.out.println(dto.getGrade());
        Student student = studentServiceIMP.findByID(dto.getStud_id()).get();
        Professor professor = professorServiceIMP.findById(dto.getProf_id()).get();
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




}
