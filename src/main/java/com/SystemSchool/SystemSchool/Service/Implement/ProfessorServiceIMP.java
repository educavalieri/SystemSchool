package com.SystemSchool.SystemSchool.Service.Implement;

import com.SystemSchool.SystemSchool.Model.Entities.Professor;
import com.SystemSchool.SystemSchool.Model.Repository.ProfessorRepository;
import com.SystemSchool.SystemSchool.Service.Interface.ProfessorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProfessorServiceIMP implements ProfessorServiceInterface {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor saveProfessor(Professor professor) {

        try {
            Professor result = professorRepository.save(professor);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Professor> findById(Integer id) {

        return professorRepository.findById(id);
    }

    @Override
    public Professor findByName(String professor_name) {

        return professorRepository.findByName(professor_name);
    }

    @Override
    public void deleteProfessor(Integer id) {
        Professor professor = findById(id).orElse(null);
        professorRepository.delete(professor);
    }

    @Override
    public Page<Professor> viewAll(Pageable pageable) {
        return professorRepository.findAll(pageable);
    }


}
