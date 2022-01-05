package com.SystemSchool.SystemSchool.Controller.DTO;

import java.util.Objects;

public class ProfessorSubjectDTO {

    private Integer subject_id;

    private Integer prof_subject_id;

    public ProfessorSubjectDTO(Integer subject_id, Integer prof_subject_id) {
        this.subject_id = subject_id;
        this.prof_subject_id = prof_subject_id;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getProf_subject_id() {
        return prof_subject_id;
    }

    public void setProf_subject_id(Integer prof_subject_id) {
        this.prof_subject_id = prof_subject_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorSubjectDTO that = (ProfessorSubjectDTO) o;
        return Objects.equals(subject_id, that.subject_id) && Objects.equals(prof_subject_id, that.prof_subject_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject_id, prof_subject_id);
    }

    @Override
    public String toString() {
        return "ProfessorSubjectDTO{" +
                "subject_id=" + subject_id +
                ", prof_subject_id=" + prof_subject_id +
                '}';
    }
}
