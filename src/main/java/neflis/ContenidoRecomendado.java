package neflis;

import neflis.Contenido;
import neflis.ContenidoUnitario;
import neflis.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContenidoRecomendado {
    private List<ContenidoUnitario> contenidosDestacados= new ArrayList<>();
    public Usuario usuario;
    public Contenido contenido;

    public List<Contenido> contenidosIncompletos(){ return
            this.usuario.getContenido().stream().filter(c->!c.fueVistoCompletaX(usuario)).collect(Collectors.toList());}

    public List<ContenidoUnitario> getContenidosDestacados(){  return contenidosDestacados;  }

    public void setContenidosDestacados(List<ContenidoUnitario> contenidosRecomendadosEmpresa) {
        this.contenidosDestacados = contenidosRecomendadosEmpresa; }
}
