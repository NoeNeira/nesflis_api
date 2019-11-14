package neflis.neflisdemo.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import neflis.neflisdemo.util.Sha1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL) //Para que el metodo no traiga los null
public class Contenido implements Serializable {

    private String id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private SeasonApi seasons;
    private String totalSeasons = null; //null porq solo esta en series, no en peliculas.
    private List<Contenido> contenidos;

    public Contenido(){}

    public Contenido(String id, String title, String year, String runtime, String genre, String director, String actors, String plot) {
        this.id =id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.totalSeasons= totalSeasons;

    }
    public String getId() {
        return Sha1.sha1(this.toString());
    } // Sha aplicado al objeto

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
        return  genre;
    }

    public String getOneGenre(){return String.valueOf(this.getGenre().split("\\s")[1]);}

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
    }
    public String getTotalSeasons() {
        return totalSeasons;
    }
    public SeasonApi getSeasons() {
        return seasons;
    }

    public void setSeasons(SeasonApi seasons) {
        this.seasons = seasons;
    }

    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public String cortarRuntime(){ return this.getRuntime().split("\\s")[0];}}
