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
    Capitulo capitulo1;
    Capitulo capitulo2;
    List<Capitulo> capTemp1;
    List<Temporada>temporadasSerie1;
    Temporada temporada1;
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
   /* @Test
    void testMinVistosPorGenero(){
        serie1=mock(Serie.class);
        capitulo1=mock(Capitulo.class);
        capitulo2=mock(Capitulo.class);
        temporada1=mock(Temporada.class);
        capitulo1.setTemporada(temporada1);
        capitulo2.setTemporada(temporada1);
        temporada1.setSerie(serie1);
        when(temporada1.duracion()).thenReturn(58);
        //when(capitulo2.duracion()).thenReturn(57);
        //assertEquals(900, usuarioA.minVistosxGenero("Comedia").intValue());
        assertEquals(500, serie1.duracion().intValue());}*/

    @Test
    void testGenerosqueVioPorContenido(){
        List<String> generosEsperados = new ArrayList<>();
        generosEsperados.add("Drama");
        generosEsperados.add("Comedia");
        usuarioA.getContenido();
        assertEquals(generosEsperados, usuarioA.generosqueVio());

}}
