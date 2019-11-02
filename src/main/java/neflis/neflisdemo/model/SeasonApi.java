package neflis.neflisdemo.model;

import neflis.neflisdemo.util.Sha1;

import javax.print.DocFlavor;

public class SeasonApi{
    private String id;
    private String number;
    private String runtime;
    private EpisodeApi episode;
    private String number_of_episodes;

    public SeasonApi(String id, String number, String runtime, EpisodeApi episode, String number_of_episodes) {
        this.id = id;
        this.number = number;
        this.runtime = runtime;
        this.episode = episode;
        this.number_of_episodes = number_of_episodes;
    }
    public String getId() {
        return  Sha1.sha1(this.toString());
    }
    public void setId(String id) {
        this.id = id;
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

    public EpisodeApi getEpisode() {
        return episode;
    }

    public void setEpisode(EpisodeApi episode) {
        this.episode = episode;
    }

    public String getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(String number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

}
