package neflis.neflisdemo.model;


import java.util.List;

public class SerieApi extends Contenido {
    private String id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    //private SeasonApi seasons;
    private List<SeasonApi> seasons;
    private String totalseasons;

   /* public SerieApi(String id, String title, String year, String runtime, String genre, String director, String actors, String plot, SeasonApi seasons, String totalseasons) {
        super(id, title, year, runtime, genre, director, actors, plot, seasons);
        //this.seasons=seasons;
        this.totalseasons = totalseasons;
    }
    /*public SerieApi(int id, String title, String year, String runtime, String genre, String director, String actors, String plot, String totalseasons) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
       // this.seasons = seasons;
        this.totalseasons = totalseasons;}

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
    } */

    /*public List<SeasonApi> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonApi> seasons) {
        this.seasons = seasons;
    }
*/
    public String getTotalseasons() {
        return totalseasons;
    }

    public void setTotalseasons(String totalseasons) {
        this.totalseasons = totalseasons;
    }
}
