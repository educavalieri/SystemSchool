package com.SystemSchool.SystemSchool.Service.Interface;

import com.SystemSchool.SystemSchool.Model.Entities.Subject;

import java.util.List;

public interface SubjectServiceInterface {

    Subject findByIDService(Integer id);

    List<Subject> findAllService();

    void saveSubject(Subject subject);

}
