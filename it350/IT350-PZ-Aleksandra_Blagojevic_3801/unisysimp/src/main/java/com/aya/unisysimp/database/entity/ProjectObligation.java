package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

public class ProjectObligation implements Serializable {
    private static final long serialVersionUID = 19L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proj_ob_id", unique = true, updatable = false, nullable = false)
    private int projObID;

    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @OneToOne
    private Project projectID;

    public ProjectObligation() {
    }

    public ProjectObligation(Project projectID) {
        this.projectID = projectID;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProjObID() {
        return projObID;
    }

    public void setProjObID(int projObID) {
        this.projObID = projObID;
    }

    public Project getProjectID() {
        return projectID;
    }

    public void setProjectID(Project projectID) {
        this.projectID = projectID;
    }
}
