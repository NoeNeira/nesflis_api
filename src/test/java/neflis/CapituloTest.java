package neflis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CapituloTest {
    Capitulo capitulo1;
    Capitulo capitulo2;
    Capitulo capitulo3;
    Usuario usuarioA;
    List<Contenido> contenidoList;
    ContenidoUnitario contenidoUnitario;
    Serie serie1;

    @BeforeEach
    void setup() {
        capitulo1 = new Capitulo(1, "actor1");
        capitulo2 = new Capitulo(2, "actor2");
        capitulo3 = mock(Capitulo.class);

        contenidoList = new ArrayList<>();
        contenidoList.add(capitulo2);
        contenidoList.add(capitulo3);

        usuarioA = new Usuario();
        usuarioA.setContenido(contenidoList);

        serie1= new Serie("Friends");
        serie1.setGenero("Comedia");
        capitulo1.setSerie(serie1);
    }
    @Test
    void testFueVistoCompleto(){
        usuarioA.getContenido();
        assertFalse(capitulo1.fueVistoCompletaX(usuarioA));
        assertTrue(capitulo2.fueVistoCompletaX(usuarioA));
        }
    @Test
    void testGeneroCapitulos(){
        assertEquals("Comedia", capitulo1.genero());
    }


    }

