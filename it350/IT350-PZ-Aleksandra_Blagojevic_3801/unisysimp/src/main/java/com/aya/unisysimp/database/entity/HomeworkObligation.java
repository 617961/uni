package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "homework_obligation")
public class HomeworkObligation implements Serializable {
    private static final long serialVersionUID = 18L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hw_ob_id", unique = true, updatable = false, nullable = false)
    private int homeworkObID;

    @JoinColumn(name = "homework_id", referencedColumnName = "homework_id")
    @OneToOne
    private Homework homeworkID;

    @Column(name = "prev_sent", nullable = false)
    private short prevSent;

    public HomeworkObligation() {
    }

    public HomeworkObligation(Homework homeworkID, short prevSent) {
        this.homeworkID = homeworkID;
        this.prevSent = prevSent;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getHomeworkObID() {
        return homeworkObID;
    }

    public void setHomeworkObID(int homeworkObID) {
        this.homeworkObID = homeworkObID;
    }

    public Homework getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(Homework homeworkID) {
        this.homeworkID = homeworkID;
    }

    public short getPrevSent() {
        return prevSent;
    }

    public void setPrevSent(short prevSent) {
        this.prevSent = prevSent;
    }
}
