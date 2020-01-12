package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_obligation")
public class TestObligation implements Serializable {
    private static final long serialVersionUID = 17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_ob_id", unique = true, updatable = false, nullable = false)
    private int testObID;

    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    @OneToOne
    private Test testID;

    public TestObligation() {
    }

    public TestObligation(Test testID) {
        this.testID = testID;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTestObID() {
        return testObID;
    }

    public void setTestObID(int testObID) {
        this.testObID = testObID;
    }

    public Test getTestID() {
        return testID;
    }

    public void setTestID(Test testID) {
        this.testID = testID;
    }
}
