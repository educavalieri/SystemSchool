package com.SystemSchool.SystemSchool.Service.Interface;

import com.SystemSchool.SystemSchool.Model.Entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface StudentServiceInterface {

    Optional<Student> findByID(Integer id);

    Student saveStudent(Student student);

    void deleteStudent(Integer id);

    Student findByMotherName(String mother_name);

    Page<Student> findAllStudent(Pageable pageable);

    Page<Student> searchName(String student_name, Pageable pageable);







}
