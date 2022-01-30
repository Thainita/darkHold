package com.thairodrigues.darkhold.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "tb_mesurement")
@EntityListeners(AuditingEntityListener.class)
public class Mesurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_mesurement_id")
        private long mesurementId;

    @ManyToOne
    @JoinColumn(name = "fk_person_id", referencedColumnName = "pk_person_id")
    private Person person;

    @Column(name = "weight")
        private float weight;

    public long getMesurementId() {
        return mesurementId;
    }

    public void setMesurementId(long mesurementId) {
        this.mesurementId = mesurementId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
