package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.ContenidoApi;
import neflis.neflisdemo.model.SeasonApi;
import neflis.neflisdemo.service.ContenidoService;
import neflis.neflisdemo.service.SerieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContenidoController {
    private ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @GetMapping("/contents") //Trae todos los contenidos, series y peliculas
    public List<Contenido> contents() {
        return contenidoService.cargarContenidosIniciales();
    } //http://localhost:8080/contents

    @GetMapping("/contentsTitulo") //Trae el contenido por titulo
    public List<Contenido> contents(@RequestParam(value = "title", required = false) String title) {
        return contenidoService.contenidoPorTitulo(title);
    }// http://localhost:8080/contentsTitulo?title=You

    @GetMapping("/contentsRuntime")
    public Integer contentss (/*@PathVariable(value = "genre") String genre,
                                     @RequestParam(value = "runtime", required = false) String  runtime)*/
                                     @RequestParam(value = "genre", required = false) String  genre)
        {return contenidoService.minVistosxGenero(genre);}}

    /*@PostMapping("/contents")
    public ContenidoApi addContent(@RequestBody ContenidoApi contents){
        return contenidoService.agregarC

    @GetMapping("/contentsRuntime") //Trae el contenido por titulo
    public List<Contenido> contentss (@RequestParam(value = "runtime", required = false) String runtime) {
        return contenidoService.contenidoPorRuntime(runtime);
}}


    /*@PostMapping("/contents")
    public ContenidoApi addContent(@RequestBody ContenidoApi contents){
        return contenidoService.agregarContents(contents);}}*/
