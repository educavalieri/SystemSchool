package com.SystemSchool.SystemSchool.Model.Repository;

import com.SystemSchool.SystemSchool.Model.Entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("SELECT obj from Professor obj WHERE LOWER(obj.professor_name) LIKE LOWER(CONCAT('%', :professor_name, '%'))")
    Professor findByName(String professor_name);
}
