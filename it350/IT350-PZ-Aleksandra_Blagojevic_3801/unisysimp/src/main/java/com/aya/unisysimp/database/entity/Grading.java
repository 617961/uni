package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "grading")
public class Grading implements Serializable {
    private static final long serialVersionUID = 20L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grading_id", unique = true, updatable = false, nullable = false)
    private int gradingID;

    @JoinColumn(name = "stud_id", referencedColumnName = "stud_id")
    @OneToMany
    private Student studentID;

    @JoinColumn(name = "prof_id", referencedColumnName = "prof_id")
    @OneToMany
    private Professor professorID;

    @JoinColumn(name = "obli_def_id", referencedColumnName = "obli_def_id")
    @OneToOne
    private ObligationDefinition obliDefID;

    @Column(name = "file_location", nullable = false)
    private String fileLocation;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "points", nullable = false)
    private double points;

    @Column(name = "days_late", nullable = false)
    private short daysLate;

    public Grading() {
    }

    public Grading(Student studentID, Professor professorID, ObligationDefinition obliDefID, String fileLocation, LocalDate date, double points, short daysLate) {
        this.studentID = studentID;
        this.professorID = professorID;
        this.obliDefID = obliDefID;
        this.fileLocation = fileLocation;
        this.date = date;
        this.points = points;
        this.daysLate = daysLate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getGradingID() {
        return gradingID;
    }

    public void setGradingID(int gradingID) {
        this.gradingID = gradingID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public Professor getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Professor professorID) {
        this.professorID = professorID;
    }

    public ObligationDefinition getObliDefID() {
        return obliDefID;
    }

    public void setObliDefID(ObligationDefinition obliDefID) {
        this.obliDefID = obliDefID;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public short getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(short daysLate) {
        this.daysLate = daysLate;
    }
}
