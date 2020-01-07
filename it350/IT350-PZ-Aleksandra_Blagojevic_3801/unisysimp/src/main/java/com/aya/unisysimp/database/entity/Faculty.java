package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {
    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id", unique = true, updatable = false, nullable = false)
    private int facultyID;

    @JoinColumn(name = "degree_id", referencedColumnName = "degree_id")
    @OneToOne
    private Degree degreeID;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    public Faculty() {
    }

    public Faculty(Degree degreeID, String facultyName) {
        this.degreeID = degreeID;
        this.facultyName = facultyName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public Degree getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(Degree degreeID) {
        this.degreeID = degreeID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
