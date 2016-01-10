package com.free.agent.model;

import com.free.agent.field.DayOfWeek;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by antonPC on 29.12.15.
 */
@Entity
@Table(name = "DAY")
public class Day extends AbstractTable<Long> {

    @Id
    @Column(name = "DAY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "DAY_OF_WEEK")
    private DayOfWeek dayOfWeek;

    public Day() {
    }

    public Day(Date date, DayOfWeek dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public Day(Schedule schedule, Date date, DayOfWeek dayOfWeek) {
        this.schedule = schedule;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Date getDate() {
        return ObjectUtils.clone(date);
    }

    public void setDate(Date date) {
        this.date = ObjectUtils.clone(date);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
