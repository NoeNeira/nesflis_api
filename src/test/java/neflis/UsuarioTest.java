package neflis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioTest {
    Usuario usuarioA;
    List<Contenido> contenidoVisto;
    Pelicula pelicula1;
    Pelicula pelicula2;
    Serie serie1;
    Serie serie2;



    @BeforeEach
    void setUp(){
        usuarioA=new Usuario();

        pelicula1= new Pelicula("Actor1");
        pelicula2= new Pelicula("Actor2");
        pelicula1.setGenero("Drama");
        pelicula1.genero();
        pelicula2.setGenero("Comedia");
        pelicula2.genero();
        pelicula1.setDuracion(200);
        pelicula2.setDuracion(210);

        serie1= new Serie("Friends");
        serie1.setGenero("Comedia");
        serie1.genero();

        contenidoVisto= new ArrayList<>();
        contenidoVisto.add(pelicula1);
        contenidoVisto.add(pelicula2);
        contenidoVisto.add(serie1);

        usuarioA.setContenido(contenidoVisto);
    }
    @Test
    void testVioContenidoCompleto(){
        usuarioA.getContenido();
        assertTrue(usuarioA.vioContenidoCompleto(pelicula1));
        assertTrue(usuarioA.vioContenidoCompleto(serie1));
        assertFalse(usuarioA.vioContenidoCompleto(serie2));

    }

    @Test
    void testGenerosqueVioPorContenido(){
        List<String> generosEsperados = new ArrayList<>();
        generosEsperados.add("Drama");
        generosEsperados.add("Comedia");
        usuarioA.getContenido();
        assertEquals(generosEsperados, usuarioA.generosqueVio());

}}
