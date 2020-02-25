package com.aya.unisysimp.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true, updatable = false)
    private int personID;

    @Column(name = "jmbg", nullable = false)
    private String jmbg;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "city_of_birth", nullable = false)
    private String cityOfBirth;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(String jmbg, String name, String surname, String phoneNumber, String email, String cityOfBirth, LocalDate dateOfBirth) {
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cityOfBirth = cityOfBirth;
        this.dateOfBirth = dateOfBirth;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void createPerson(String jmbg, String name, String surname, String phoneNumber, String email, String cityOfBirth, LocalDate dateOfBirth){
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unisysimp");
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try{
            et = em.getTransaction();
            et.begin();
            Person person = new Person();
            person.setJmbg(jmbg);
            person.setName(name);
            person.setSurname(surname);
            person.setPhoneNumber(phoneNumber);
            person.setEmail(email);
            person.setCityOfBirth(cityOfBirth);
            person.setDateOfBirth(dateOfBirth);
            em.persist(person);
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
    public Person getPerson(String jmbg){
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unisysimp");
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "select p from Person p where p.jmbg = :jmbg";

        TypedQuery<Person> tq = em.createQuery(query, Person.class);
        tq.setParameter("jmbg", jmbg);
        Person person = null;
        try{
            person = tq.getSingleResult();
            return person;
        } catch(NoResultException ex){
            ex.printStackTrace();
            return null;
        } finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }
    public List<Person> getPersons(){
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unisysimp");
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "select p from Person p where p.jmbg is not null";

        TypedQuery<Person> tq = em.createQuery(strQuery, Person.class);
        List<Person> persons;

        try{
            persons = tq.getResultList();
            return persons;
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
