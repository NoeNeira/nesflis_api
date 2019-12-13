package neflis;

public class Pelicula extends ContenidoUnitario{
    public String genero;
    public Integer duracion;
    public Boolean actorActuo;

    public Pelicula( String actores){
        this.actores=actores;

    }
    public Boolean fueVistoCompletaX(Usuario usuario){
        return usuario.getContenido().contains( this );}

    public void setGenero(String genero) {
        this.genero = genero;}
    public String genero() {
        return genero;}
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public Integer duracion() {
        return duracion;
    }
    //protected Boolean generoMasVisto() {
     //   return generoMasVisto();

    public String getActor(){return actores;}}
    //public Boolean actorActuo(Contenido contenidoVisto){

