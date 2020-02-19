package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "curriculum")
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 25L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id", unique = true, updatable = false, nullable = false)
    private int curriculumID;

    @JoinColumn(name = "year_id", referencedColumnName = "year_id")
    @OneToMany
    private ArrayList<StudyYear> studyYearList;

    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    @OneToOne
    private Semester semesterID;

    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @OneToMany
    private ArrayList<StudyProgram> studyProgramList;

    public Curriculum() {
    }

    public Curriculum(ArrayList<StudyYear> studyYearList, Semester semesterID, ArrayList<StudyProgram> studyProgramList) {
        this.studyYearList = studyYearList;
        this.semesterID = semesterID;
        this.studyProgramList = studyProgramList;
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

    public ArrayList<StudyYear> getStudyYearList() {
        return studyYearList;
    }

    public void setStudyYearList(ArrayList<StudyYear> studyYearList) {
        this.studyYearList = studyYearList;
    }

    public Semester getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(Semester semesterID) {
        this.semesterID = semesterID;
    }

    public ArrayList<StudyProgram> getStudyProgramList() {
        return studyProgramList;
    }

    public void setStudyProgramList(ArrayList<StudyProgram> studyProgramList) {
        this.studyProgramList = studyProgramList;
    }
    public void addCurriculum(ArrayList<StudyYear> studyYearList, Semester semesterID, ArrayList<StudyProgram> studyProgramList){


    }
}
