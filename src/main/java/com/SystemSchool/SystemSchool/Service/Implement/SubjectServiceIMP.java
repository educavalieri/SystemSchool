package com.SystemSchool.SystemSchool.Service.Implement;

import com.SystemSchool.SystemSchool.Model.Entities.Subject;
import com.SystemSchool.SystemSchool.Model.Repository.SubjectRepository;
import com.SystemSchool.SystemSchool.Service.Interface.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceIMP implements SubjectServiceInterface {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject findByIDService(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if(!subject.isPresent()){
            throw new RuntimeException("user doesn't find");
        }
        return subject.orElse(null);
    }

    @Override
    public List<Subject> findAllService() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }

    @Override
    public void saveSubject(Subject subject) {

        try {
            subjectRepository.save(subject);
            System.out.println("subject add");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("system can't add subject");
        }
    }
}
