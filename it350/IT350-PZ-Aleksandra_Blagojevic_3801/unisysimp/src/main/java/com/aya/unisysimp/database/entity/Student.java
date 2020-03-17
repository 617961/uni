package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 2L;

    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id", unique = true, updatable = false)
    private int studentID;

    @Column(name = "study_type", nullable = false)
    private String studyType;

    @Column(name = "stud_email", nullable = false)
    private String studentEmail;

    public Student() {
    }

    public Student(Person personID, String studyType, String studentEmail) {
        this.personID = personID;
        this.studyType = studyType;
        this.studentEmail = studentEmail;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void createStudent(String studyType, String studentEmail){
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unisysimp");
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try{
            et = em.getTransaction();
            et.begin();
            Student stud = new Student();
            stud.setStudyType(studyType);
            stud.setStudentEmail(studentEmail);
            em.persist(stud);
            et.commit();
        } catch(Exception ex){
            if(et != null){
                et.rollback();
            }
            ex.printStackTrace();
        }finally{
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    public Student getStudent(int id){
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unisysimp");
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "select s from Student s where s.id = :stud_id";

        TypedQuery<Student> tq = em.createQuery(query, Student.class);
        tq.setParameter("stud_id", id);
        Student stud = null;
        try{
            stud = tq.getSingleResult();
            return stud;
        } catch(NoResultException ex){
            ex.printStackTrace();
            return null;
        } finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }
    public List<Student> getStudents(){
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unisysimp");
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "select s from Student s where s.studentID is not null";

        TypedQuery<Student> tq = em.createQuery(strQuery, Student.class);
        List<Student> students;

        try{
            students = tq.getResultList();
            return students;
        } catch (NoResultException ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }
}
