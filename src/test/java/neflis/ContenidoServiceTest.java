package neflis;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
import neflis.neflisdemo.service.ContenidoService;
import neflis.neflisdemo.service.UserService;
import neflis.neflisdemo.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ContenidoServiceTest {
    UserApi yaz;
    UserService userService;
    List<Contenido> contenidoList;

    Contenido titanic;
    Contenido brave_heart;
    Contenido breaking_bad;


    @BeforeEach
    void setUp() {
        yaz = new UserApi("1L", "yaz");
        titanic = mock(Contenido.class);
        brave_heart = mock(Contenido.class);
        breaking_bad = mock(Contenido.class);
        contenidoList = new ArrayList<>();
        contenidoList.add(titanic);
        contenidoList.add(brave_heart);
        contenidoList.add(breaking_bad);

        when(titanic.getGenre()).thenReturn("romance");
        when(brave_heart.getGenre()).thenReturn("drama");
        when(brave_heart.getGenre()).thenReturn("drama");
        when(titanic.getRuntime()).thenReturn("180 min");
        when(breaking_bad.getRuntime()).thenReturn("1500 min");
        when(brave_heart.getRuntime()).thenReturn("120 min");
    }
    @Test
    void testContenidosTotales() {
        assertEquals(3, contenidoList.size());
    }
}