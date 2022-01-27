package com.thairodrigues.darkhold.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_person")
@EntityListeners(AuditingEntityListener.class)
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "pk_person_id")
    private long personId;

  @Column(name = "first_name", nullable = false)
    private String firstName;

  @Column(name = "last_name", nullable = true)
    private String lastName;

  @Column(name = "birth_date", nullable = false)
    private Date birthDate;

  @Column(name = "email", nullable = false)
    private String email;


    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long pk_person_id) {
        this.personId = pk_person_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
