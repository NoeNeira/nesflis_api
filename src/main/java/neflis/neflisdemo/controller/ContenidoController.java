package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.service.ContenidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContenidoController {
    private ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }
    /** 1er Ejercicio. http://localhost:8080/contents**/
    @GetMapping("/contents") //Trae todos los contenidos, series y peliculas
    public List<Contenido> contents() {
        return contenidoService.cargarContenidosIniciales(); //cambiar nombre a metodo fetch
    }

    @GetMapping("/contentsTitulo") //Trae el contenido por titulo
    public List<Contenido> contents(@RequestParam(value = "title", required = false) String title) {
        return contenidoService.contenidoPorTitulo(title);
    } // http://localhost:8080/contentsTitulo?title=You  vergit

    /*@GetMapping("/contentsRuntime/{genre}")
    public List<Contenido> contentss (@PathVariable(value = "genre") String genre,
                                      @RequestParam(value = "runtime", required = false) String  runtime)
                                    // @RequestParam(value = "genre", required = false) String  genre)
        {return contenidoService.contenidoPorRuntime(genre, runtime);}


    /*@PostMapping("/contents")
    public Contenido addContents(@RequestBody Contenido contenido){
        return
                contenidoService.agregarContenido(contenido);}*/
}
    /*@PostMapping("/contents")
    public Contenido addContent(@RequestBody Contenido contents){
        return contenidoService.agregarC public Integer minVistosxGenero(String genre){return
            cargarContenidosIniciales().stream().filter( c->c.getGenre()
                    .equals( genre ) ).mapToInt( c-> c.cortarRuntime())
                    .sum();}


    /*@PostMapping("/contents")
    public Contenido addContent(@RequestBody Contenido contents){
        return contenidoService.agregarContents(contents);}}*/
