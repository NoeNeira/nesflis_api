package neflis.neflisdemo.service;


import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.ContenidoApi;
import neflis.neflisdemo.model.MovieApi;
import neflis.neflisdemo.model.SerieApi;
import neflis.neflisdemo.persistance.ContenidoStorage;
import neflis.neflisdemo.util.CustomObjectMapper;
import neflis.neflisdemo.util.Util;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContenidoService {
    public ContenidoStorage contenidoStorage;
    private List<ContenidoApi> contentsList;
    private List<Contenido> contenidos;

    public ContenidoService(ContenidoStorage contenidoStorage) {
        this.contenidoStorage = contenidoStorage;

    }


    public ContenidoService(){
        if(this.contenidos == null){
            this.contenidos = cargarContenidosIniciales();
        }
    }

    public List<Contenido> contenidoSerie(){
        List<Contenido> contenidoTotalSerie= new ArrayList<>();
        String serie1 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;
        String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
        String serie3 = Util.URL_API + "?t=you&apikey=" + Util.API_KEY;
        Contenido f = getContenido(serie1);
        Contenido g = getContenido(serie2);
        Contenido h = getContenido(serie3);
        contenidoTotalSerie.add(f);
        contenidoTotalSerie.add(g);
        contenidoTotalSerie.add(h);
        return contenidoTotalSerie;


    }
    public List<Contenido> cargarContenidosIniciales() {
        List<Contenido> contenidoTotal= new ArrayList<>();
        String movie1URL = Util.URL_API + "?t=brave+heart&apikey=" + Util.API_KEY;
        String movie2URL = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
        String movie3URL = Util.URL_API + "?t=mask&apikey=" + Util.API_KEY;

        Contenido c = getContenido(movie1URL);
        Contenido d = getContenido(movie2URL);
        Contenido e = getContenido(movie3URL);


        /*
        movies.add(c);
        movies.add(d);
        movies.add(e);*/
        contenidoTotal.add(c);
        contenidoTotal.add(d);
        contenidoTotal.add(e);

        return contenidoTotal;


    }
    private Contenido getContenido(String contenido){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(contenido)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            String json = response.body().string();

            CustomObjectMapper om =  new CustomObjectMapper();
            Contenido c = om.readValue(json,Contenido.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);
    /*private MovieApi getContenidoMovie(String movie){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(movie)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            String json = response.body().string();

            CustomObjectMapper om =  new CustomObjectMapper();
            MovieApi c = om.readValue(json,MovieApi.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);
        }
    }

    private SerieApi getContenidoSeries(String serie){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(serie)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            String json = response.body().string();

            CustomObjectMapper om =  new CustomObjectMapper();
            SerieApi c = om.readValue(json,SerieApi.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading contentt", e);
        }
    }
    /*
    private Contenido getMovie(String movie){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(movie)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            String json = response.body().string();

            CustomObjectMapper om =  new CustomObjectMapper();
            Contenido c = om.readValue(json,Contenido.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);
        }
    }*/
        }}

    public List<ContenidoApi> getContentsList() {
        contentsList = contenidoStorage.contents();
     return contentsList;
        /*if (contentsList == null) {
            contentsList = new ArrayList<>();
        }
        return contentsList;
    }*/
    }

    public void setContentsList(List<ContenidoApi> contentsList) {
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