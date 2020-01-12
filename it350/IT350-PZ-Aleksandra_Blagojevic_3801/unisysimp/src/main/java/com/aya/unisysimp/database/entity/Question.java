package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    private static final long serialVersionUID = 15L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", unique = true, updatable = false, nullable = false)
    private int questionID;

    @Column(name = "ans1", nullable = false)
    private String ans1;

    @Column(name = "ans2", nullable = false)
    private String ans2;

    @Column(name = "ans3", nullable = false)
    private String ans3;

    @Column(name = "correct", nullable = false)
    private String correct;

    public Question() {
    }

    public Question(String ans1, String ans2, String ans3, String correct) {
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.correct = correct;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
