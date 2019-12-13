package neflis.neflisdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import neflis.neflisdemo.util.Sha1;

import javax.print.DocFlavor;
import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EpisodeApi implements Serializable {

    private String id;
    //private String number;
    private String runtime;
    private String actors;
    private String title;
    private String episode;
    private String imdbId;
    private String season;
    private SerieApi serie;
    private SeasonApi seasonApi;

    public EpisodeApi() { }

    public EpisodeApi(String title, String episode, String runtime, String imdbId, String actors) {
        this.title = title;
        this.episode = episode;
        this.runtime = runtime;
        this.imdbId = imdbId;
        this.actors = actors;
    }
    public String getId() {

        return Sha1.sha1(this.toString());//Id para cada episodio, pero tmb pusimos el id de imdb
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getActors() {
        return actors;
    }

    public SeasonApi getSeasonApi() {
        return seasonApi;
    }

    public void setSeasonApi(SeasonApi seasonApi) {
        this.seasonApi = seasonApi;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public SerieApi getSerie() {
        return serie;
    }

    public void setSerie(SerieApi serie) {
        this.serie = serie;
    }
}