package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.EpisodeApi;
import neflis.neflisdemo.model.SeasonApi;
import neflis.neflisdemo.model.SerieApi;
import neflis.neflisdemo.service.EpisodeService;
import neflis.neflisdemo.service.SeasonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpisodeController {
    private EpisodeService episodeService; //Controller de episodio, A REVISAR!

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }
    @GetMapping("/contents/{title}/{season}")
    public List<EpisodeApi> episodiosSerie(@PathVariable( value= "title") String title,
                                          @PathVariable(value= "season") String season,
                                          @RequestParam(value = "episode", required = false) String episode) {
        return episodeService.contenidoPorEpisodio(title, season, episode);
    }
    @GetMapping("/contentsEpisodio")
    public List<EpisodeApi> episodiosSerie(@RequestParam(value = "episode", required = false) String episode) {
        return episodeService.contenidoEpisodio(episode);}}
