package com.SystemSchool.SystemSchool.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "professor", schema = "public")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Integer professor_id;

    @Column(name = "professor_name")
    private String professor_name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "notas", joinColumns = @JoinColumn(name = "prof_id"), inverseJoinColumns = @JoinColumn(name = "stud_id"))
    private Set<Student> students = new HashSet<>();

    Professor(){
    }

    Professor(String professor_name){
        this.professor_name = professor_name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Integer getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Integer professor_id) {
        this.professor_id = professor_id;
    }

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(professor_id, professor.professor_id) && Objects.equals(professor_name, professor.professor_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor_id, professor_name);
    }
}
