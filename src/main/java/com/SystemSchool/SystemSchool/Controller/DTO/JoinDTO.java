package com.SystemSchool.SystemSchool.Controller.DTO;

import java.util.Objects;

public class JoinDTO {

    private Integer stud_id;

    private Integer prof_id;

    private Integer grade;

    public JoinDTO(){

    }

    public JoinDTO(Integer stud_id, Integer prof_id, Integer grade) {
        this.stud_id = stud_id;
        this.prof_id = prof_id;
        this.grade = grade;
    }

    public Integer getStud_id() {
        return stud_id;
    }

    public void setStud_id(Integer stud_id) {
        this.stud_id = stud_id;
    }

    public Integer getProf_id() {
        return prof_id;
    }

    public void setProf_id(Integer prof_id) {
        this.prof_id = prof_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinDTO joinDTO = (JoinDTO) o;
        return Objects.equals(stud_id, joinDTO.stud_id) && Objects.equals(prof_id, joinDTO.prof_id) && Objects.equals(grade, joinDTO.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stud_id, prof_id, grade);
    }
}
