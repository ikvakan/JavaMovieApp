/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author IgorKvakan
 */
public class Movie implements Comparable<Movie>{
    
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    
    
    private int id;
    private String title;
    private String description;
    private String directors;
    private String actors;
    private String duration;
    private String genre;    
    private String pubDate;
    private String picturePath;

    public Movie(int id, String title, String description, String directors, String actors, String duration, String genre, String pubDate, String picturePath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.directors = directors;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.pubDate = pubDate;
        this.picturePath = picturePath;
    }

    public Movie(String title, String description, String directors, String actors, String duration, String genre, String pubDate, String picturePath) {
        this.title = title;
        this.description = description;
        this.directors = directors;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.pubDate = pubDate;
        this.picturePath = picturePath;
    }

    public Movie() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getDirector() {
        return directors;
    }

    public void setDirector(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return  title ;
    }

    @Override
    public int compareTo(Movie m) {
       return title.compareTo(m.title);
    }
    
    
    
}
