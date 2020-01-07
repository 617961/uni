package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "study_program")
public class StudyProgram implements Serializable {
    private static final long serialVersionUID = 7L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id", unique = true, updatable = false, nullable = false)
    private int programID;

    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    @OneToMany
    private Faculty facultyID;

    @Column(name = "study_name", nullable = false)
    private String studyName;

    @Column(name = "duration", nullable = false)
    private short duration;

    @Column(name = "min_espb", nullable = false)
    private short minEspb;

    @Column(name = "study_title", nullable = false)
    private String studyTitle;

    public StudyProgram() {
    }

    public StudyProgram(Faculty facultyID, String studyName, short duration, short minEspb, String studyTitle) {
        this.facultyID = facultyID;
        this.studyName = studyName;
        this.duration = duration;
        this.minEspb = minEspb;
        this.studyTitle = studyTitle;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public Faculty getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Faculty facultyID) {
        this.facultyID = facultyID;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public short getMinEspb() {
        return minEspb;
    }

    public void setMinEspb(short minEspb) {
        this.minEspb = minEspb;
    }

    public String getStudyTitle() {
        return studyTitle;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }
}
