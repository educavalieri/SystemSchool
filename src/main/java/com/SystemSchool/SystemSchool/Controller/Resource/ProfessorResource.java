package com.SystemSchool.SystemSchool.Controller.Resource;

import com.SystemSchool.SystemSchool.Controller.DTO.ProfessorSubjectDTO;
import com.SystemSchool.SystemSchool.Model.Entities.Professor;
import com.SystemSchool.SystemSchool.Model.Entities.Subject;
import com.SystemSchool.SystemSchool.Service.Implement.ProfessorServiceIMP;
import com.SystemSchool.SystemSchool.Service.Implement.SubjectServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorServiceIMP professorServiceIMP;

    @Autowired
    private SubjectServiceIMP subjectServiceIMP;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Professor save(@RequestBody Professor professor){
        try {
            System.out.println(professor.getProfessor_name());
            Professor result =  professorServiceIMP.saveProfessor(professor);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
            return null;
        }
    }

    @RequestMapping(value = "/view{id}", method = RequestMethod.GET)
    public Professor findById(@PathVariable("id") Integer id){
      Professor professor = professorServiceIMP.findById(id);
      return professor;
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") Integer id){
        Professor professor = professorServiceIMP.findById(id);
        professorServiceIMP.deleteProfessor(id);
        System.out.println("user deleted");
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public Page<Professor> findAll(Pageable pageable){

        return professorServiceIMP.viewAll(pageable);
    }

    @RequestMapping(value = "/findname{name}", method = RequestMethod.GET)
    public Professor findByName(@PathVariable("name") String professor_name){
        return professorServiceIMP.findByName(professor_name);
    }


    @RequestMapping(value = "/insertmat", method = RequestMethod.POST)
    public Professor insertMateria(@RequestBody ProfessorSubjectDTO dto){
        Subject subject = subjectServiceIMP.findByIDService(dto.getSubject_id());
        Professor professor = professorServiceIMP.findById(dto.getProf_subject_id());
        professor.setSubjects(subject);
        professorServiceIMP.saveProfessor(professor);
        return professor;
    }





}
