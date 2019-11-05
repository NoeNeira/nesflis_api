package neflis.neflisdemo.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import neflis.neflisdemo.util.Sha1;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) //Para no mostrar los atributos en null
public class SerieApi implements Serializable {

    private String id;
    private String title;
    private String year;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String season;
    private String totalSeasons;
    private List<EpisodeApi> episodes;
    public EpisodeApi episodeApi;
    private String episode;

    public SerieApi(){}

    public SerieApi(String title, String season, String totalSeasons, List<EpisodeApi> episodes){
        this.title=title;
        this.season=season;
        this.totalSeasons=totalSeasons;
        this.episodes=episodes;
    }

    public String getId() {
        return Sha1.sha1(toString());
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

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
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
