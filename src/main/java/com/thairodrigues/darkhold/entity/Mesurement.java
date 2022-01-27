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

    @Column(name = "weight")
        private float weight;
}
