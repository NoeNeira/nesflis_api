package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.SeasonApi;
import neflis.neflisdemo.model.SerieApi;
import neflis.neflisdemo.service.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {
    private SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/title")
    public List<SerieApi> serieApi(@RequestParam(value = "title", required = false) String title) {
        return serieService.contenidoPorTitle(title);
    }
}