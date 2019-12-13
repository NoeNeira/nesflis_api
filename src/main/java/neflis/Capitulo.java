package neflis;

public class Capitulo extends ContenidoUnitario{
    public Integer duracion;
    protected Integer numeroCap;
    protected Serie serie;
    protected String genero;

    public Temporada temporada;

    public Capitulo(Integer numeroCap, String actores) {
        this.actores=actores;
        this.numeroCap=numeroCap;}

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public void setSerie(Serie serie){this.serie=serie;}

    public Serie getSerie() {
        return serie;
    }
    public Boolean fueVistoCompletaX(Usuario usuario){
        return usuario.getContenido().contains( this );}

    public String genero() { return this.serie.genero();}

     /**tengo duracion de un capitulo**/
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public Integer duracion() {
        return this.duracion;
    }
}




