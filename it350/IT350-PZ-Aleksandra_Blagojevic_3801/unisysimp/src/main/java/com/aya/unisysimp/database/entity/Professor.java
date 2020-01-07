package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "professor")
public class Professor implements Serializable {
    private static final long serialVersionUID = 3L;

    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne
    private Person personID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id", unique = true, updatable = false, nullable = false)
    private int professorID;

    @Column(name = "study_title")
    private String studyTitle;

    @Column(name = "prof_email")
    private String professorEmail;

    public Professor() {
    }

    public Professor(Person personID, String studyTitle, String professorEmail) {
        this.personID = personID;
        this.studyTitle = studyTitle;
        this.professorEmail = professorEmail;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getStudyTitle() {
        return studyTitle;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }
}
