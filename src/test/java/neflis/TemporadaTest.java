package neflis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TemporadaTest {
    Capitulo capitulo1;
    Capitulo capitulo2;
    Capitulo capitulo3;
    Capitulo capitulo4;
    List<Capitulo> capTemp1;
    List<Capitulo> capTemp2;
    Temporada temporada1;
    Temporada temporada2;
    List<Temporada>temporadasSerie1;
    List<Contenido> contenidosVistos;
    Usuario usuarioA;
    Serie serie1;
    Serie serie2;

    @BeforeEach
    void setUp(){
        capitulo1=new Capitulo(1, "actor1");
        capitulo2=new Capitulo(2, "actor2");

        capitulo3= mock(Capitulo.class);
        capitulo4=mock(Capitulo.class);

        capTemp1= new ArrayList<>();
        capTemp1.add(capitulo1);
        capTemp1.add(capitulo2);
        capTemp2= new ArrayList<>();
        capTemp2.add(capitulo3);
        capTemp2.add(capitulo4);

        temporada1= new Temporada(1);
        temporada2= new Temporada(2);

        temporada1.setCapitulos(capTemp1);
        temporada2.setCapitulos(capTemp2);
        temporadasSerie1= new ArrayList<>();
        temporadasSerie1.add(temporada1);
        temporadasSerie1.add(temporada2);

        serie1= new Serie("Friends");
        serie2= new Serie ("Breaking Bad");

        serie1.setGenero("Comedia");
        serie2.setGenero("Drama");

        temporada1.setSerie(serie1);
        temporada2.setSerie(serie1);

        contenidosVistos= new ArrayList<>();
        contenidosVistos.add(capitulo2);
        contenidosVistos.add(capitulo1);

        usuarioA= new Usuario();

        capitulo1.fueVistoCompletaX(usuarioA);
        capitulo2.fueVistoCompletaX(usuarioA);
    }
    @Test
    void testFueVistoCompletoTemp2(){
        when(capitulo3.fueVistoCompletaX(usuarioA)).thenReturn(true);
        when(capitulo4.fueVistoCompletaX(usuarioA)).thenReturn(true);
        assertTrue(temporada2.fueVistoCompletaX(usuarioA));

    }
    @Test
    void testFueVistoCompletpTemp1(){
        usuarioA.setContenido(contenidosVistos);
        usuarioA.getContenido();
        assertTrue(temporada1.fueVistoCompletaX(usuarioA));
    }
    @Test
    void testDuracionTemp2(){
        when(capitulo3.duracion()).thenReturn(58);
        when (capitulo4.duracion()).thenReturn(56);
        assertEquals(114, temporada2.duracion().intValue());
    }
    @Test
    void testDuracionTemp1(){
        capitulo1.setDuracion(57);
        capitulo2.setDuracion(58);
        assertEquals(115, temporada1.duracion().intValue());
    }
    @Test
    void testGeneroTemporada(){
        assertEquals("Comedia", temporada1.genero());


    }
}


