package com.aya.unisysimp.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "semester")
public class Semester {
    private static final long serialVersionUID = 6L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id", unique = true, updatable = false, nullable = false)
    private int semesterID;

    @Column(name = "semester_code", nullable = false)
    private short semesterCode;

    public Semester() {
    }

    public Semester(short semesterCode) {
        this.semesterCode = semesterCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public short getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(short semesterCode) {
        this.semesterCode = semesterCode;
    }
}
