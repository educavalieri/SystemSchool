package com.SystemSchool.SystemSchool.Model.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "subject", schema = "public")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subject_id;

    @Column(name = "subject_name")
    private String subject_name;

    public Subject(){
    }

    public Subject(String subject_name){
        this.subject_name = subject_name;
    }

    public Integer getSubject_id() {
        return subject_id;
    }


    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subject_id, subject.subject_id) && Objects.equals(subject_name, subject.subject_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject_id, subject_name);
    }
}
