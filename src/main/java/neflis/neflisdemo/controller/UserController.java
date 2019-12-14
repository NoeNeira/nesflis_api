package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
import neflis.neflisdemo.service.ContenidoService;
import neflis.neflisdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    private ContenidoService contenidoService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* @GetMapping("/users/{id}")
    public List<UserApi> usuarioContenido(@PathVariable (value="id") Long id,
                                          @RestController (value="genre", required = false) String genre){
        return userService.featureContents(genre);
    }*/

    /**Ejercicio 3. http://localhost:8080/users/1L/watched**/
    @GetMapping("/users/{id}/watched")
    public List<UserApi> usuarioContenido (@PathVariable(value = "id") String id,
                                          @RequestParam(value = "watched", required = false) String watched) {
        return userService.usuariosPorId(id);
    }

    /**Ejercicio 2. http://localhost:8080/users/1L/featured**/
    @GetMapping("/users/{id}/featured")
    public List<UserApi> contenidoRuntimes (@PathVariable(value = "id") String id,
                                              @RequestParam(value="featured", required = false) String featured)
    { return userService.usuariosPorIdContenidoRecomendado(id);}
    }



