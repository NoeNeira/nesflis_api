package neflis.neflisdemo.controller;

import neflis.Contenido;
import neflis.neflisdemo.model.ContenidoApi;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import neflis.neflisdemo.service.ContenidoApiService;

import java.util.List;

@RestController
public class ContenidoApiController {

    private ContenidoApiService contenidoService;
    public ContenidoApiController(ContenidoApiService contenidoService){
        this.contenidoService=contenidoService;
    }

    @GetMapping("/contents")
    public List<Contenido> contents(){
        return contenidoService.cargarContenidosIniciales();
    }
    }

