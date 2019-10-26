package neflis.neflisdemo.model;

public class MovieApi extends Contenido {
    private int id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;

    public MovieApi(int id, String title, String year, String runtime, String genre, String director, String actors, String plot) {
        super(id, title, year, runtime, genre, director, actors, plot);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String getRuntime() {
        return runtime;
    }

    @Override
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getActors() {
        return actors;
    }

    @Override
    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String getPlot() {
        return plot;
    }

    @Override
    public void setPlot(String plot) {
        this.plot = plot;
    }
}
