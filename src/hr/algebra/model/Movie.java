/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author IgorKvakan
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","title", "description", "directors", "actors", "duration", "genre", "pubDate","picturePath"})
public class Movie implements Comparable<Movie> {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    //@XmlElementWrapper
    
    @XmlElement(name="id")
    private int id;

    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "directors")
    private String directors;
    @XmlElement(name = "actors")

    private String actors;
    @XmlElement(name = "duration")

    private String duration;
    @XmlElement(name = "genre")

    private String genre;
    @XmlElement(name = "pubDate")

    private String pubDate;
    @XmlElement(name="picturePath")
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

    public String getDirector() {
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
        return id + " - " + title + " - " + genre;
    }

    @Override
    public int compareTo(Movie m) {
        return title.compareTo(m.title);
    }

}
