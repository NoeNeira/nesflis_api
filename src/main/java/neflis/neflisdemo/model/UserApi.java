package neflis.neflisdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserApi {
    private String id;
    private String username;
    private List<Contenido> contenidos;
    //private List<Contenido> contenidoRecomendado;


    public UserApi(){}

    public UserApi(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setContenidos(List<Contenido> contenidos){
        this.contenidos=contenidos;}

    /*public List<Contenido> getContenidoRecomendado() {
        return contenidoRecomendado;
    }

    public void setContenidoRecomendado(List<Contenido> contenidoRecomendado) {
        this.contenidoRecomendado = contenidoRecomendado;
    }*/

    public List<Contenido> getContenidos(){return contenidos;

    }


}

