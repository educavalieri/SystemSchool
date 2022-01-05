package com.SystemSchool.SystemSchool.Controller.Resource;

import com.SystemSchool.SystemSchool.Model.Entities.Subject;
import com.SystemSchool.SystemSchool.Model.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectResource {

    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Subject save(@RequestBody Subject subject){
        Subject result = subjectRepository.save(subject);
        return result;
    }

    @RequestMapping(value = "/view{id}", method = RequestMethod.GET)
    public Subject view(@PathVariable("id") Integer id){
        return subjectRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public List<Subject> viewAll(){
        List<Subject> result = subjectRepository.findAll();
        return result;
    }

}
