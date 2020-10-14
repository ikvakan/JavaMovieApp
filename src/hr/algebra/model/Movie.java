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
public class Movie {
    
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    
    private int id;
    private String title;
    private String description;
    private List<Director> directors;
    private List<Actor> actors;
    private int duration;
    private LocalDateTime pubDate;
    private String genre;
    private String picturePath;

    public Movie(int id, String title, String description, List<Director> directors, List<Actor> actors, int duration, LocalDateTime pubDate, String genre, String picturePath) {
        this( title,  description,  directors, actors,  duration,  pubDate,  genre,  picturePath);
        this.id = id;
        
    }

    public Movie(String title, String description, List<Director> directors, List<Actor> actors, int duration, LocalDateTime pubDate, String genre, String picturePath) {
        this.title = title;
        this.description = description;
        this.directors = directors;
        this.actors = actors;
        this.duration = duration;
        this.pubDate = pubDate;
        this.genre = genre;
        this.picturePath = picturePath;
    }

    public Movie(int id, String title, String description, int duration, LocalDateTime pubDate, String genre, String picturePath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.pubDate = pubDate;
        this.genre = genre;
        this.picturePath = picturePath;
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

    public List<Director>  getDirector() {
        return directors;
    }

    public void setDirector(List<Director> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
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
    
    
    
}
