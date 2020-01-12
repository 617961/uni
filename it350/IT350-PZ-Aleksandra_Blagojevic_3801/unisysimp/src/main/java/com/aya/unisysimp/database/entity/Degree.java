package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "degree")
public class Degree implements Serializable {
    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id", unique = true, updatable = false, nullable = false)
    private int degreeID;

    @Column(name = "degree_name", nullable = false)
    private String degreeName;

    public Degree() {
    }

    public Degree(String degreeName) {
        this.degreeName = degreeName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
