package neflis.neflisdemo.model;

import javax.print.DocFlavor;

public class SeasonApi{
    private int id;
    private String number;
    private String runtime;
    private EpisodeApi episode;
    private String number_of_episodes;

    public SeasonApi(int id, String number, String runtime, EpisodeApi episode, String number_of_episodes) {
        this.id = id;
        this.number = number;
        this.runtime = runtime;
        this.episode = episode;
        this.number_of_episodes = number_of_episodes;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
