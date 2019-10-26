package neflis.neflisdemo.model;

import java.io.Serializable;

public class ContenidoApi implements Serializable {
    private String id;
    private String title;
    private Integer year;
    private Integer duration;
    private String genre;
    private String directors;
    private String actors;
    private String plot;
    private String season;

    public ContenidoApi(String id, String title, Integer year, Integer duration, String genre, String directors, String actors, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.plot = plot;
    }
    public ContenidoApi(String id, String title, Integer year, Integer duration, String genre, String directors,
                     String actors, String plot, String season) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.plot = plot;
        this.season=season;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }


}
