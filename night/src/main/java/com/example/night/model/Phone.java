package com.example.night.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Phone")
public  class Phone {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "`number`")
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name ="PERSON_ID_FK")
  
    )
  
    private Person person;
    
    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }
    public void setId(int id) {
    	this.id =id;
    }

    public int getId() {
        return id;
    }
    public void setNumber(String number) {
        this.number =number;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}