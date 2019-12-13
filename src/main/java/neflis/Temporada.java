package neflis;

import java.util.List;


public class Temporada implements Contenido {


    public Serie serie;
    public List<Capitulo> capitulos;
    Integer numTemp;
    //public Integer duracion;
    public String genero;


    public Temporada(Integer numTemp){
        this.numTemp=numTemp;
    }
    public List<Capitulo> getCapitulos() {
        return capitulos;
    }
    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Boolean fueVistoCompletaX(Usuario usuario) {
        return this.capitulos.stream().
                allMatch( capitulo -> capitulo.fueVistoCompletaX( usuario ) );
    }
    public String genero() {
        return serie.genero();}

    /**obtengo duracion de cada capitulo sumado**/
    public Integer duracion(){
        return capitulos.stream().map( c -> c.duracion() ).reduce( 0, Integer::sum );

    }
    public Integer getDuracion(){return this.duracion();}
    /**Obtengo ultimo cap de la serie**/
    public Capitulo ultimoCapituloSerie() {
        return capitulos.get(capitulos.size()-1); }

}

