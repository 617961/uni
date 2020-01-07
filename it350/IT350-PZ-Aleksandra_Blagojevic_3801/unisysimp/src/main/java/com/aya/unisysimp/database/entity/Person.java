package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true, updatable = false, nullable = false)
    private int id;

    @Column(name = "")
}
