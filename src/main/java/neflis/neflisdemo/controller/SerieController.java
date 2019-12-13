package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.EpisodeApi;
import neflis.neflisdemo.model.SeasonApi;
import neflis.neflisdemo.model.SerieApi;
import neflis.neflisdemo.service.SeasonService;
import neflis.neflisdemo.service.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {
    private SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/contents/{title}") //Pido como parametro el titulo, y como request la temporada. Ok!!
    public List<SerieApi> contenidoSerie(@PathVariable(value = "title") String title,
                                         @RequestParam(value = "season", required = false) String season) {
        return serieService.contenidoPorSeason(title, season);
        //localhost:8080/contents/Breaking Bad?season=1
    }
}
    /*@GetMapping("/contents/{title}/{season}")
    public List<SerieApi> contenidoSeriePorEpisode(@PathVariable( value= "title") String title,
                                                   @PathVariable(value= "season") String season,
                                                   @RequestParam(value = "episode", required = false)List<String> episode) {
        return serieService.contenidoPorEpisodio(title, season, episode);
    }}*/ 