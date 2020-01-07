package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "study_year")
public class StudyYear implements Serializable {
    private static final long serialVersionUID = 9L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "year_id", unique = true, updatable = false, nullable = false)
    private int yearID;

    @Column(name = "yearstart", nullable = false)
    private LocalDate yearStart;

    @Column(name = "yearend", nullable = false)
    private LocalDate yearEnd;

    public StudyYear() {
    }

    public StudyYear(LocalDate yearStart, LocalDate yearEnd) {
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getYearID() {
        return yearID;
    }

    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    public LocalDate getYearStart() {
        return yearStart;
    }

    public void setYearStart(LocalDate yearStart) {
        this.yearStart = yearStart;
    }

    public LocalDate getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(LocalDate yearEnd) {
        this.yearEnd = yearEnd;
    }
}
