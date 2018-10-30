package com.app.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class MovieShow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String movieShowName;

    @Column(nullable = false)
    private Long duration;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time;

    public MovieShow(){}

    public MovieShow(String movieShowName, Long duration, LocalDateTime time) {
        this.movieShowName = movieShowName;
        this.duration = duration;
        this.time = time;
    }

    public MovieShow(Long id, String movieShowName, Long duration, LocalDateTime time) {
        this.id = id;
        this.movieShowName = movieShowName;
        this.duration = duration;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getMovieShowName() {
        return movieShowName;
    }

    public Long getDuration() {
        return duration;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
