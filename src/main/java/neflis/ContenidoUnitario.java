package neflis;

public class ContenidoUnitario implements Contenido {

    protected String actores;
    String genero;
    Integer duracion;

    //public Boolean fueVistoCompletaPor(Usuario usuario);

    @Override
    public String genero() {
        return genero;
    }

    @Override
    public Integer duracion() {
        return duracion;
    }

    @Override
    public Boolean fueVistoCompletaX(Usuario usuario) {
        return usuario.vioContenidoCompleto(this);
    }
}
