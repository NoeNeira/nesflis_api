package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.ContenidoApi;
import neflis.neflisdemo.service.ContenidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContenidoController {
    private ContenidoService contenidoService;
    public ContenidoController(ContenidoService contenidoService){
        this.contenidoService=contenidoService;
    }

    @GetMapping("/contents")
    public List<ContenidoApi> contents(){
        return contenidoService.getContentsList();
    }}
    /*@PostMapping("/contents")
    public ContenidoApi addContent(@RequestBody ContenidoApi contents){
        return contenidoService.agregarContents(contents);}}

    @RequestMapping(value = "/contents", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public String getAllContentsJSON (Model model)
    {
        model.addAttribute("contents", contenidoService.getContentsList() );
        return "jsonTemplate";
    }
    @RequestMapping(value = "/Contents", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody ContenidoApi contents)
    {
        System.out.println(contents);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}*/
