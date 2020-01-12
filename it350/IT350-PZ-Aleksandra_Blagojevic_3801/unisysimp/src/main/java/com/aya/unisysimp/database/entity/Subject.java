package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    private static final long serialVersionUID = 10L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", unique = true, updatable = false, nullable = false)
    private int subjectID;

    @JoinColumn(name = "prof_id", referencedColumnName = "prof_id")
    @OneToMany
    private Professor professorID;

    @Column(name = "subject_code", nullable = false)
    private String subjectCode;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "espb", nullable = false)
    private short subjectEspb;

    @JoinColumn(name = "stud_id", referencedColumnName = "stud_id")
    @ManyToMany
    private List<Student> students;

    public Subject() {
    }

    public Subject(Professor professorID, String subjectCode, String subjectName, short subjectEspb, List<Student> students) {
        this.professorID = professorID;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectEspb = subjectEspb;
        this.students = students;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public Professor getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Professor professorID) {
        this.professorID = professorID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public short getSubjectEspb() {
        return subjectEspb;
    }

    public void setSubjectEspb(short subjectEspb) {
        this.subjectEspb = subjectEspb;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
