package com.SystemSchool.SystemSchool.Service.Implement;

import com.SystemSchool.SystemSchool.Model.Entities.Student;
import com.SystemSchool.SystemSchool.Model.Repository.StudentRepository;
import com.SystemSchool.SystemSchool.Service.Interface.StudentServiceInterface;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceIMP implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<Student> findByID(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = findByID(id).get();
        studentRepository.delete(student);

    }

    @Override
    public Student findByMotherName(String mother_name) {
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Page<Student> searchName(String student_name, Pageable pageable) {
        return null;
    }
}
