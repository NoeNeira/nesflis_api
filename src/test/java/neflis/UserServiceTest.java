package neflis;

import neflis.neflisdemo.controller.UserController;
import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
import neflis.neflisdemo.service.UserService;
import neflis.neflisdemo.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserController userController;
    private UserService userService;
    private UserApi userApi;
    UserApi yaz;
    UserApi noe;
    UserApi nadia;
    Contenido titanic;
    Contenido brave_heart;
    Contenido breaking_bad;
    List<Contenido> contenidoList;
    List<String> contenidoPorgenreList;

    @BeforeEach
    void setUp() {
        yaz = new UserApi("1L", "yaz");
        noe = new UserApi("2L", "noe");
        nadia = new UserApi("3L", "nadia");
        titanic = mock(Contenido.class);
        brave_heart = mock(Contenido.class);
        breaking_bad = mock(Contenido.class);
        contenidoList = new ArrayList<>();
        contenidoList.add(titanic);
        contenidoList.add(brave_heart);
        contenidoList.add(breaking_bad);
        contenidoPorgenreList = new ArrayList<>();
        contenidoPorgenreList.add(titanic.getGenre());
        contenidoPorgenreList.add(brave_heart.getGenre());
        contenidoPorgenreList.add(breaking_bad.getGenre());
        when(titanic.getGenre()).thenReturn("romance");
        when(brave_heart.getGenre()).thenReturn("drama");
        when(brave_heart.getGenre()).thenReturn("drama");
        when(titanic.getRuntime()).thenReturn("180 min");
        when(breaking_bad.getRuntime()).thenReturn("1500 min");
        when(brave_heart.getRuntime()).thenReturn("120 min");
    }

   /* @Test
    public void testGetUsuarios(){
        userService.usuarios();

     System.out.println(userService.usuarios());
     //assertEquals(3, userService.usuarios().size());

    }*/


}