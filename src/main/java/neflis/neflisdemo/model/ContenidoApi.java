package neflis.neflisdemo.model;

import neflis.neflisdemo.utils.Sha1;

import java.io.Serializable;

public class ContenidoApi implements Serializable {
    private String id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String directors;
    private String actors;
    private String plot;
    private String season;

    protected Sha1 sha;

   // private List<Pelicula> peliculas;
    //private List<Serie> series;

    public ContenidoApi(){};

    public ContenidoApi(String id, String title, String year, String runtime, String genre, String directors, String actors, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.plot = plot;
    }
    public ContenidoApi(String id, String title, String year, String runtime, String genre, String directors,
                     String actors, String plot, String season) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.plot = plot;
        this.season=season;
    }

    public String getId() {
        return sha.generarId();
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
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
