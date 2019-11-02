package neflis.neflisdemo.model;


import java.io.Serializable;
import java.util.List;
public class SerieApi implements Serializable {

    private String id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    //private SeasonApi seasons;
    private String season;
   // private SeasonApi seasons;
    private String totalSeasons;
    private List<EpisodeApi> episodes;

    public SerieApi(){}
    public SerieApi(String title, String season, String totalSeasons, List<EpisodeApi> episodes){
        this.title=title;
        this.season=season;
        this.totalSeasons=totalSeasons;
        this.episodes=episodes;
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public List<EpisodeApi> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodeApi> episodes) {
        this.episodes = episodes;
    }
}

   /* public SerieApi(String id, String title, String year, String runtime, String genre, String director, String actors, String plot, SeasonApi seasons, String totalseasons) {
        super(id, title, year, runtime, genre, director, actors, plot, seasons);
        //this.seasons=seasons;
        this.totalseasons = totalseasons;
    String genre, String director, String actors, String plot, String totalseasons)
}*/
