package com.SystemSchool.SystemSchool.Model.Repository;

import com.SystemSchool.SystemSchool.Model.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
