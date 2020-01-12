package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subject_definition")
public class SubjectDefinition implements Serializable {
    private static final long serialVersionUID = 11L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_def_id", unique = true, updatable = false, nullable = false)
    private int subDefID;

    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id")
    @OneToMany
    private Curriculum curriculumID;

    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @OneToMany
    private Subject subjectID;

    public SubjectDefinition() {
    }

    public SubjectDefinition(Curriculum curriculumID, Subject subjectID) {
        this.curriculumID = curriculumID;
        this.subjectID = subjectID;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSubDefID() {
        return subDefID;
    }

    public void setSubDefID(int subDefID) {
        this.subDefID = subDefID;
    }

    public Curriculum getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(Curriculum curriculumID) {
        this.curriculumID = curriculumID;
    }

    public Subject getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID = subjectID;
    }
}
