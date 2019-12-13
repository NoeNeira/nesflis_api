package neflis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PeliculaTest {
    Pelicula pelicula1;
    Pelicula pelicula2;
    Usuario usuarioA;
    List<Contenido>contenidoVisto;

    @BeforeEach
    void setUp(){
    usuarioA= new Usuario();
    pelicula1=new Pelicula("actor1");
    pelicula2= new Pelicula("actor2");
    List<Contenido>contenidoVisto= new ArrayList<>();
    contenidoVisto.add(pelicula1);
    usuarioA.setContenido(contenidoVisto);
    }

    @Test
    public void testFueVistoCompleta(){
    usuarioA.getContenido();
    assertTrue(pelicula1.fueVistoCompletaX(usuarioA));
    assertFalse(pelicula2.fueVistoCompletaX(usuarioA));}
    }
