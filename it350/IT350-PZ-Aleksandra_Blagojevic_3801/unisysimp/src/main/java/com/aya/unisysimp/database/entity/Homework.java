package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "homework")
public class Homework implements Serializable {
    private static final long serialVersionUID = 14L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_id", unique = true, updatable = false, nullable = false)
    private int homeworkID;

    @Column(name = "homework_num", nullable = false)
    private short homeworkNum;

    @Column(name = "homework_text", nullable = false)
    private String homeworkText;

    public Homework() {
    }

    public Homework(short homeworkNum, String homeworkText) {
        this.homeworkNum = homeworkNum;
        this.homeworkText = homeworkText;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(int homeworkID) {
        this.homeworkID = homeworkID;
    }

    public short getHomeworkNum() {
        return homeworkNum;
    }

    public void setHomeworkNum(short homeworkNum) {
        this.homeworkNum = homeworkNum;
    }

    public String getHomeworkText() {
        return homeworkText;
    }

    public void setHomeworkText(String homeworkText) {
        this.homeworkText = homeworkText;
    }
}
