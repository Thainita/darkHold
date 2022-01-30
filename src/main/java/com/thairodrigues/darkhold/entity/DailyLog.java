package com.thairodrigues.darkhold.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "tb_daily_log")
@EntityListeners(AuditingEntityListener.class)
public class DailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_daily_log_id")
    private long dailyLogId;

    @ManyToOne
    @JoinColumn(name = "fk_person_id", referencedColumnName = "pk_person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "fk_routine_id", referencedColumnName = "pk_routine_id")
    private Routine routine;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "set_group")
    private int setGroup;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int reps;

    @Column(name = "special_set_flag")
    private String specialSetFlag;

    @Column(name = "additional_comments")
    private String additionalComments;

    public long getDailyLogId() {
        return dailyLogId;
    }

    public void setDailyLogId(long dailyLogId) {
        this.dailyLogId = dailyLogId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSetGroup() {
        return setGroup;
    }

    public void setSetGroup(int setGroup) {
        this.setGroup = setGroup;
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

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
}
