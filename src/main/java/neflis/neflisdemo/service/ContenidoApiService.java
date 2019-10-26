package neflis.neflisdemo.service;

import neflis.Contenido;
import neflis.neflisdemo.model.ContenidoApi;
import neflis.neflisdemo.persistance.ContenidoApiStorage;
import neflis.neflisdemo.utils.Sha1;


import neflis.neflisdemo.persistance.ContenidoApiStorage;
import neflis.neflisdemo.utils.CustomObjectMapper;
import neflis.neflisdemo.utils.Util;
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


import java.util.List;

public class ContenidoApiService {
    public ContenidoApiStorage contenidoStorage;
    private ContenidoApi contenido;
    private List<ContenidoApi> contentsList;
    private List<ContenidoApi> contenidos;

    public ContenidoApiService(ContenidoApiStorage contenidoStorage) {
        this.contenidoStorage = contenidoStorage;

    }


    public ContenidoApiService() {
        if (this.contenidos == null) {
            this.contenidos = cargarContenidosIniciales();
        }
    }


    public List<Contenido> cargarContenidosIniciales() {

        List<Contenido> movies = new ArrayList<>();

        String movie1URL = Util.URL_API + "?t=braveheart&apikey=" + Util.API_KEY;
        String movie2URL = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
        String movie3URL = Util.URL_API + "?t=mask&apikey=" + Util.API_KEY;

        Contenido c = getMovie(movie1URL);
        movies.add(c);
//        movies.add(getMovie(movie2URL));
//        movies.add(getMovie(movie3URL));


        return movies;


    }


    private Contenido getMovie(String movie) {
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

            CustomObjectMapper om = new CustomObjectMapper();
            Contenido c = om.readValue(json, Contenido.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);
        }
    }


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

    //***********************************************************************************************
    public Sha1 miSha;

    public String agregarId(){
    String miShaEnString = miSha.toString();
    contenido.setId(miShaEnString);
    return contenido.getId();


}


}
