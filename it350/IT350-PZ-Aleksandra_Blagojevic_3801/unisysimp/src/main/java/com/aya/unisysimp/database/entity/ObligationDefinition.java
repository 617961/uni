package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "obligation_definition")
public class ObligationDefinition implements Serializable {
    private static final long serialVersionUID = 12L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obli_def_id", unique = true, updatable = false, nullable = false)
    private int obliDefID;

    @JoinColumn(name = "sub_def_id", referencedColumnName = "sub_def_id")
    @OneToMany
    private SubjectDefinition subDefID;

    @Column(name = "max_points")
    private double maxPoints;

    public ObligationDefinition() {
    }

    public ObligationDefinition(SubjectDefinition subDefID, double maxPoints) {
        this.subDefID = subDefID;
        this.maxPoints = maxPoints;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getObliDefID() {
        return obliDefID;
    }

    public void setObliDefID(int obliDefID) {
        this.obliDefID = obliDefID;
    }

    public SubjectDefinition getSubDefID() {
        return subDefID;
    }

    public void setSubDefID(SubjectDefinition subDefID) {
        this.subDefID = subDefID;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(double maxPoints) {
        this.maxPoints = maxPoints;
    }
}
