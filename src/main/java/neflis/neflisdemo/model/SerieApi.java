package neflis.neflisdemo.model;

public class SerieApi extends Contenido {
    private int id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private SeasonApi seasons;

    public SerieApi(int id, String title, String year, String runtime, String genre, String director, String actors, String plot, SeasonApi seasons, String number_of_seasons) {
        super(id, title, year, runtime, genre, director, actors, plot);
        this.seasons=seasons;
        this.number_of_seasons = number_of_seasons;
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
    }

    public SeasonApi getSeasons() {
        return seasons;
    }

    public void setSeasons(SeasonApi seasons) {
        this.seasons = seasons;
    }

    public String getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(String number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    private String number_of_seasons;





}
