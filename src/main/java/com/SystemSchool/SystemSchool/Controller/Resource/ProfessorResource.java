package com.SystemSchool.SystemSchool.Controller.Resource;

import com.SystemSchool.SystemSchool.Model.Entities.Professor;
import com.SystemSchool.SystemSchool.Service.Implement.ProfessorServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorServiceIMP professorServiceIMP;

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
        Optional<Professor> professor = professorServiceIMP.findById(id);
        if(!professor.isPresent()){
            System.out.println("id is not present");
            return null;
        }
        return professor.get();
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") Integer id){
        Optional<Professor> professor = professorServiceIMP.findById(id);
        if (!professor.isPresent()){
            System.out.println("user is not found");
        }
        professorServiceIMP.deleteProfessor(id);
        System.out.println("user deleted");
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public Page<Professor> findAll(Pageable pageable){
        return professorServiceIMP.viewAll(pageable);
    }

}
