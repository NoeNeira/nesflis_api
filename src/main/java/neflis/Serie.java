package neflis;

import java.util.List;

public class Serie implements Contenido {

    String nombreSerie;
    public List<Temporada> temporadas;
    public String genero;
    //public Integer duracion;

    public Serie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public Boolean fueVistoCompletaX(Usuario usuario) {
        return this.temporadas.stream().
                allMatch( temporadas -> temporadas.fueVistoCompletaX( usuario ) );
    }
    public Integer duracion() {
        return temporadas.stream().map( t -> t.duracion() )
                .reduce( 0, Integer::sum );
    }
    public Integer getDuracion(){return this.duracion();}
    /** 3 ejercicio**/
    public Capitulo ultimoCapituloSerie() {
        return temporadas.get( temporadas.size() - 1 ).ultimoCapituloSerie();
    }
    /** 4 ejercicio**/

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String genero() {
        return genero;
    }
    //public Boolean actorActuo(){}

}


