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

    @JoinColumn(name = "hw_ob_id", referencedColumnName = "hw_ob_id")
    @OneToMany
    private HomeworkObligation hwObID;

    @JoinColumn(name = "proj_ob_id", referencedColumnName = "proj_ob_id")
    @OneToOne
    private ProjectObligation projObID;

    @JoinColumn(name = "test_ob_id", referencedColumnName = "test_ob_id")
    @OneToMany
    private TestObligation testObID;

    @JoinColumn(name = "sub_def_id", referencedColumnName = "sub_def_id")
    @OneToOne
    private SubjectDefinition subDefID;

    @Column(name = "max_points")
    private double maxPoints;

    public ObligationDefinition() {
    }

    public ObligationDefinition(HomeworkObligation hwObID, ProjectObligation projObID, TestObligation testObID, SubjectDefinition subDefID, double maxPoints) {
        this.hwObID = hwObID;
        this.projObID = projObID;
        this.testObID = testObID;
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

    public HomeworkObligation getHwObID() {
        return hwObID;
    }

    public void setHwObID(HomeworkObligation hwObID) {
        this.hwObID = hwObID;
    }

    public ProjectObligation getProjObID() {
        return projObID;
    }

    public void setProjObID(ProjectObligation projObID) {
        this.projObID = projObID;
    }

    public TestObligation getTestObID() {
        return testObID;
    }

    public void setTestObID(TestObligation testObID) {
        this.testObID = testObID;
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
