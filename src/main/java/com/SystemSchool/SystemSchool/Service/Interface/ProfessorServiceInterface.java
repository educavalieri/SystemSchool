package com.SystemSchool.SystemSchool.Service.Interface;

import com.SystemSchool.SystemSchool.Model.Entities.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProfessorServiceInterface {

    Professor saveProfessor(Professor professor);

    Optional<Professor> findById(Integer id);

    Professor findByName(String professor_name);

    void deleteProfessor(Integer id);

    Page<Professor> viewAll(Pageable pageable);



}
