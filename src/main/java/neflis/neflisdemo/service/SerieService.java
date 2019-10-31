package neflis.neflisdemo.service;


import neflis.neflisdemo.model.SerieApi;
import neflis.neflisdemo.util.CustomObjectMapper;
import neflis.neflisdemo.util.Util;
import okhttp3.OkHttpClient;
import okhttp3.Call;

import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SerieService {
 /*  private List<SerieApi> serieList;

    public SerieService(){
        if(this.serieList == null){
            this.serieList= contenidoSerie();}}



    public List<SerieApi> contenidoSerie() {
            List<SerieApi> contenidoTotalSerie = new ArrayList<>();
            String serie1 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;
            String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
            String serie3 = Util.URL_API + "?t=you&apikey=" + Util.API_KEY;
            SerieApi f = getContenidoSeries(serie1);
            SerieApi g = getContenidoSeries(serie2);
            SerieApi h = getContenidoSeries(serie3);
            contenidoTotalSerie.add(f);
            contenidoTotalSerie.add(g);
            contenidoTotalSerie.add(h);
            return contenidoTotalSerie;
        }
    private SerieApi getContenidoSeries(String serie) {
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

                CustomObjectMapper om = new CustomObjectMapper();
                SerieApi c = om.readValue(json, SerieApi.class);
                return c;
            } catch (IOException e) {
                //log + tirar la excepcion
                e.printStackTrace();
                throw new RuntimeException("There was an error reading contentt", e);
            }
        }*/
}