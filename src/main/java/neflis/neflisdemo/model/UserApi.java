package neflis.neflisdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserApi {

    private String id;
    private String username;
    private List<Contenido> contenidos;
    public List<Contenido> contenidoVisto;
    public List<Contenido> contenidoRecomendado;
    public Contenido contenido;

    public UserApi() {
    }

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

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public List<Contenido> getContenidoRecomendado() {
        return contenidoRecomendado;
    }

    public void setContenidoRecomendado(List<Contenido> contenidoRecomendado) {
        this.contenidoRecomendado = contenidoRecomendado;
    }
    public List<Contenido> getContenidos() {
        return contenidos;
    }
/*
    public List<Contenido> contenidoRecomendados() {
        return contenidoRecomendado.stream().filter(c -> c.getGenre().equals(generosqueVio())).collect(Collectors.toList());
    }
*/
    public List<String> generosqueVio(){
    return contenidos.stream().map( contenidoVisto -> contenidoVisto.getGenre())
            .distinct().collect( Collectors.toList());}

    public String generoPreferido() {
        return this.generosqueVio().stream()
                .max(Comparator.comparing(g-> this.minVistosxGenero(g))).get();

    }
    public List<Contenido> contenidoVistoDe(String genre){
        return contenidos.stream()
                .filter(c -> c.getGenre().equals(genre))
                .collect(Collectors.toList());
    }
    public Integer minVistosxGenero(String genre) {
        return this.contenidoVistoDe(genre).stream().mapToInt(Contenido::cortarRuntime)
                        .sum();
    }
    public String generoRecomendado;
    public void setGeneroRecomendado(String generoRecomendado){
        this.generoRecomendado=generoRecomendado;
    }
    public String getGeneroPreferido(){
        return generoRecomendado;
    }
}
