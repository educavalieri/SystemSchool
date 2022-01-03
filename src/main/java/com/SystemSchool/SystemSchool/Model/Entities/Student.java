package com.SystemSchool.SystemSchool.Model.Entities;

import com.SystemSchool.SystemSchool.Model.Enumns.Serie;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student", schema = "public")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "serie")
    private Serie serie;

    @Column(name = "father_name")
    private String father_name;

    @Column(name = "mother_name")
    private String mother_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    Set<Professor> professors = new HashSet<>();

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public Student(){

    }

    public Student(String student_name, Serie serie, String father_name, String mother_name) {
        this.student_name = student_name;
        this.serie = serie;
        this.father_name = father_name;
        this.mother_name = mother_name;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(student_id, student.student_id) && Objects.equals(student_name, student.student_name) && serie == student.serie && Objects.equals(father_name, student.father_name) && Objects.equals(mother_name, student.mother_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, student_name, serie, father_name, mother_name);
    }
}
