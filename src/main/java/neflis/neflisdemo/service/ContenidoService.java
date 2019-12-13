package neflis.neflisdemo.service;


import neflis.neflisdemo.model.Contenido;
//import neflis.neflisdemo.persistance.ContenidoRepository;
import neflis.neflisdemo.persistance.ContenidoStorage;
import neflis.neflisdemo.util.CustomObjectMapper;
import neflis.neflisdemo.util.Util;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContenidoService {
    public ContenidoStorage contenidoStorage;
    private List<Contenido> contentsList;
    private List<Contenido> contenidos;
    //private ContenidoRepository contenidoRepository;

    public ContenidoService(ContenidoStorage contenidoStorage){
        this.contenidoStorage=contenidoStorage;}
    /*public ContenidoService(ContenidoRepository contenidoRepository)
    { this.contenidoRepository = contenidoRepository; }*/

    public void contenidoService(){
        if(this.contenidos == null){
            this.contenidos= cargarContenidosIniciales();
    }}

    /*public Contenido agregarContenido (Contenido contenido){ return
            contenidoRepository.save(contenido);
    }*/

    public Integer minVistosxGenero(String genre){return
            cargarContenidosIniciales().stream().filter( c->c.getGenre()
                    .equals( genre ) ).mapToInt( c-> c.cortarRuntime())
                    .sum();}

    public List<Contenido> contenidoPorRuntime( String genre, String runtime) {
        return contenidoPorGenre(genre).stream().filter(c->c.cortarRuntime().equals(runtime)).collect(Collectors.toList());}

    public List<Contenido> contenidoPorGenre(String genre){
        if(genre== null) {
            return cargarContenidosIniciales();}
            else {
        return cargarContenidosIniciales().stream().filter(c->c.getGenre().equals(genre)).collect(Collectors.toList());
    }}
    public List<Contenido> contenidoPorTitulo(String title) { //Contenidos por titulo
        //contenidos=contenidoRepository.findAll();
        if (title == null) {
            return cargarContenidosIniciales();
        } else {
            return cargarContenidosIniciales().stream().filter(c -> c.getTitle().equals(title)).collect(Collectors.toList()
            ); }}

    public List<Contenido> cargarContenidosIniciales() { // Contenidos de series y peliculas
        List<Contenido> contenidoTotal= new ArrayList<>();
        String movie1URL = Util.URL_API + "?t=brave+heart&apikey=" + Util.API_KEY;
        String movie2URL = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
        String movie3URL = Util.URL_API + "?t=mask&apikey=" + Util.API_KEY;

        Contenido c = getContenido(movie1URL);
        Contenido d = getContenido(movie2URL);
        Contenido e = getContenido(movie3URL);

        String serie1 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;
        String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
        String serie3 = Util.URL_API + "?t=you&apikey=" + Util.API_KEY;

        Contenido f = getContenido(serie1);
        Contenido g = getContenido(serie2);
        Contenido h = getContenido(serie3);
        contenidoTotal.add(f);
        contenidoTotal.add(g);
        contenidoTotal.add(h);

        contenidoTotal.add(c);
        contenidoTotal.add(d);
        contenidoTotal.add(e);

        return contenidoTotal;
    }

    private Contenido getContenido(String contenido) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(contenido)
                .get()
                .build();// constructor del objeto

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            String json = response.body().string();

            CustomObjectMapper om = new CustomObjectMapper();
            Contenido c = om.readValue(json, Contenido.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);
        }

    }
    public List<Contenido> getContentsList() {
        contentsList = contenidoStorage.contents();
     return contentsList;
        /*if (contentsList == null) {
            contentsList = new ArrayList<>();
        }
        return contentsList;
    }*/
    }

    public void setContentsList(List<Contenido> contentsList) {
        this.contentsList = contentsList;
    }

    /*public ContenidoApi contents() {
        return contents = contenidoStorage.contents();

    public ContenidoApi getcontents() {
        return contents;
    }

    public ContenidoApi agregarContents(ContenidoApi newcontents) {
        long count = contentsList.stream().count();
        int i=contentsList.stream().skip(count - 1).findFirst().get().getId();
        newcontents.setId(i+1);
        getContentsList().add(newcontents);
        this.contenidoStorage.agregarContentss(contentsList);
        return newcontents;
    }
*/
}