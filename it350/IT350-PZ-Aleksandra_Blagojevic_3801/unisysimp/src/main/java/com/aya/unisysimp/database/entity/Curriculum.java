package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "curriculum")
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 9L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id", unique = true, updatable = false, nullable = false)
    private int curriculumID;

    @JoinColumn(name = "year_id", referencedColumnName = "year_id")
    @OneToMany
    private StudyYear yearID;

    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    @OneToOne
    private Semester semesterID;

    @JoinColumn(name = "program_id", referencedColumnName = "semester_id")
    @OneToMany
    private StudyProgram programID;

    public Curriculum() {
    }

    public Curriculum(StudyYear yearID, Semester semesterID, StudyProgram programID) {
        this.yearID = yearID;
        this.semesterID = semesterID;
        this.programID = programID;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(int curriculumID) {
        this.curriculumID = curriculumID;
    }

    public StudyYear getYearID() {
        return yearID;
    }

    public void setYearID(StudyYear yearID) {
        this.yearID = yearID;
    }

    public Semester getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(Semester semesterID) {
        this.semesterID = semesterID;
    }

    public StudyProgram getProgramID() {
        return programID;
    }

    public void setProgramID(StudyProgram programID) {
        this.programID = programID;
    }
}
