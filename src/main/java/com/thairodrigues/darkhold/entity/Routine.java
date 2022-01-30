package com.thairodrigues.darkhold.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "tb_routine")
@EntityListeners(AuditingEntityListener.class) //not sure what this is for though
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_routine_id")
    private long routineId;

    @ManyToOne
    @JoinColumn(name = "fk_person_id", referencedColumnName = "pk_person_id")
    private Person person;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int reps;

    @Column(name = "special_set_flag")
    private String specialSetFlag;

    @Column(name = "additional_commets")
    private String additionalCommets;

    public long getRoutineId() {
        return routineId;
    }

    public void setRoutineId(long routineId) {
        this.routineId = routineId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getSpecialSetFlag() {
        return specialSetFlag;
    }

    public void setSpecialSetFlag(String specialSetFlag) {
        this.specialSetFlag = specialSetFlag;
    }

    public String getAdditionalCommets() {
        return additionalCommets;
    }

    public void setAdditionalCommets(String additionalCommets) {
        this.additionalCommets = additionalCommets;
    }
}
