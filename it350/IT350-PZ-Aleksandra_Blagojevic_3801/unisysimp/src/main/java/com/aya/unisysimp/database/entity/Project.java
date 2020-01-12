package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project")
public class Project implements Serializable {
    private static final long serialVersionUID = 13L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", unique = true, updatable = false, nullable = false)
    private int projectID;

    @Column(name = "name", nullable = false)
    private String projectName;

    @Column(name = "abstract", nullable = false)
    private String projectAbstract;

    @Column(name = "key_words", nullable = false)
    private String keyWords;

    public Project() {
    }

    public Project(String projectName, String projectAbstract, String keyWords) {
        this.projectName = projectName;
        this.projectAbstract = projectAbstract;
        this.keyWords = keyWords;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAbstract() {
        return projectAbstract;
    }

    public void setProjectAbstract(String projectAbstract) {
        this.projectAbstract = projectAbstract;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
