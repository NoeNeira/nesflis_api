package neflis;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String []Args) {

       /* Usuario yaz = new Usuario();
        Usuario nadia=new Usuario();
        Usuario roma= new Usuario();
        Usuario nats= new Usuario();

        Capitulo cap1A = new Capitulo( "cap1A", "actor1", 60 );
        Capitulo cap1B = new Capitulo( "cap1B", "actor2", 58 );
        Capitulo cap2B = new Capitulo( "cap2B", "actor3", 57 );

        List<Capitulo> capA = new ArrayList<>();
        capA.add( cap1A );
        List<Capitulo> capB = new ArrayList<>();
        capB.add( cap1B );
        capB.add( cap2B );

        Temporada temporadaA = new Temporada( 1, (List<Capitulo>) capA);
        Temporada temporadaB = new Temporada( 2, (List<Capitulo>) capB );


        List<Temporada> temporadas = new ArrayList<>();
        temporadas.add( temporadaA );
        temporadas.add( temporadaB );

        Serie breakingBad = new Serie( "breaking bad", (List<Temporada>)temporadas, "drama");
        Pelicula titanic= new Pelicula(240, "Di Caprio", "romance");

        List<Contenido>contenidoVisto=new ArrayList<>(  );
        contenidoVisto.add(breakingBad);
        contenidoVisto.add(titanic);

        /** ejercicio 1

        yaz.setContenido(contenidoVisto);
        System.out.println(cap1A.fueVistoCompletaX( yaz )+ " vio cont completo capitulo");
        System.out.println( yaz.vioContenidoCompleto( titanic ) + " vio cont completo de titanic" );
        System.out.println(yaz.vioContenidoCompleto( breakingBad )+ " vio cont completo de bb");

        /** ejercicio 2*
        breakingBad.duracion();
        titanic.duracion();
        System.out.println( temporadaA.duracion()+" duracion una temporada" );
        System.out.println(breakingBad.duracion()+ " duracion de cap Breaking bad");
        System.out.println(titanic.duracion()+" duracion titanic");

        /** ejercicio 3*
        breakingBad.ultimoCapituloSerie();
        System.out.println( breakingBad.ultimoCapituloSerie().numeroCap+ " Ultimo capitulo de la serie" );

        /** ejercicio 4*
        cap1A.setSerie( breakingBad );
        cap1B.setSerie( breakingBad );
        cap2B.setSerie( breakingBad );

        temporadaA.setSerie( breakingBad );
        temporadaB.setSerie( breakingBad );

        System.out.println(cap1A.genero()+ " genero cap");
        System.out.println( temporadaA.genero() + "genero temporada");
        System.out.println( breakingBad.genero() + " genero bb");
        System.out.println( titanic.genero() + "genero titanic");

        yaz.generosqueVio().stream().forEach( genero-> System.out.println(genero +" generosss que vio"));
        System.out.println( yaz.generosqueVio() );

        /** ejercicio 5 ...*/
    }
}





