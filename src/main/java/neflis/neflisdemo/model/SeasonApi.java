package neflis.neflisdemo.model;

import neflis.neflisdemo.util.Sha1;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class SeasonApi implements Serializable {
    private String id;
    //private String number;
    //private String runtime;
    //private List<EpisodeApi> episode;
    private String number_of_episodes;
    private String title;
    private String season;
    private String totalSeasons;
    private List<EpisodeApi> episodes;
    private String episode;
    private SerieApi serieApi;
    public EpisodeApi episodeApi;

    public SeasonApi(){}

    public SeasonApi(String title, String season, String totalSeasons, List<EpisodeApi> episodes){
        this.title=title;
        this.season=season;
        this.totalSeasons=totalSeasons;
        this.episodes=episodes;
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

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getEpisode() {
        return episode;
    }

    public String getId() {
        return  Sha1.sha1(this.toString());
    }
    public void setId(String id) {
        this.id = id;
    }

    public List<EpisodeApi> getEpisodes() {
        return episodes;
    }
    public String getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(String number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public SerieApi getSerieApi() {
        return serieApi;
    }

    public void setSerieApi(SerieApi serieApi) {
        this.serieApi = serieApi;
    }

    public void setEpisode(List<EpisodeApi> episodes) {
        this.episodes = episodes;
    }
/*    public String getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(String number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public List<EpisodeApi> getEpisode() {
        return episode;
    }

    public void setEpisode(List<EpisodeApi> episode) {
        this.episode = episode;
    }

    public String getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(String number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }*/

}
