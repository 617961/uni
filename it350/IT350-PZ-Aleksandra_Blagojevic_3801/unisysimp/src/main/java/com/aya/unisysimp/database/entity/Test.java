package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test")
public class Test implements Serializable {
    private static final long serialVersionUID = 16L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id", unique = true, updatable = false, nullable = false)
    private int testID;

    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne
    private Question questionID;

    @Column(name = "test_num", nullable = false)
    private short testNum;

    public Test() {
    }

    public Test(Question questionID, short testNum) {
        this.questionID = questionID;
        this.testNum = testNum;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public Question getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Question questionID) {
        this.questionID = questionID;
    }

    public short getTestNum() {
        return testNum;
    }

    public void setTestNum(short testNum) {
        this.testNum = testNum;
    }
}
