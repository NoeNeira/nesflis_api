package neflis.neflisdemo.model;

import neflis.Pelicula;
import neflis.Serie;


import java.io.Serializable;
import java.util.List;

public class ContenidoApi /*implements Serializable*/ {
        private Integer id;
        private String title;
        private String year;
        private String runtime;
        private String genre;
        private String director;
        private String actors;
        private String plot;
        private String Season= null;

        private List<Pelicula> peliculas;
        private List<Serie> series;

        public ContenidoApi(){}

        public ContenidoApi(Integer id, String title, String year, String runtime, String genre, String director, String actors, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
    }}

