package neflis.neflisdemo.service;


import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.EpisodeApi;
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
import java.util.stream.Collectors;

@Service
public class SerieService {
   private List<SerieApi> serieList;
   private Contenido contenido;
   private List<EpisodeApi> episodes;

    public void SerieService(){
        if(this.serieList == null){
            this.serieList= cargarContenidos();}}

    public Integer episodioCortar(){
        return episodes.size();
    }
    public Integer duracionSerie(String title, String season, List<EpisodeApi> episodes){
        return cantidadEpisodios(title, season, episodes)*cortarRuntime();}

    public Integer cortarRuntime(){ return Integer.valueOf(contenido.getRuntime().split("\\s")[0]);}

    public Integer cantidadEpisodios(String title, String season, List<EpisodeApi> episodes){
        return contenidoPorEpisode(title, season, episodes).size();
      }

    public List<SerieApi> contenidoPorEpisode(String title, String season, List<EpisodeApi>episodes){ //Contenidos por titulo filtrados por temporada
        return contenidoPorSeason(title, season).stream().filter(s->s.getEpisodes().equals(episodes)).collect(Collectors.toList());
    }
    public List<SerieApi> contenidoPorSeason(String title, String season){ //Contenidos por titulo filtrados por temporada
        return contenidoPorTitulo(title).stream().filter(s->s.getSeason().equals(season)).collect(Collectors.toList());
    }
    public List<SerieApi> contenidoPorTitulo(String title) { //Contenidos por titulo
        return cargarContenidos().stream().filter(s ->s.getTitle().equals(title)).collect(Collectors.toList()
        );}


    public List<SerieApi> cargarContenidos() { //Cargo contenidos de la serie, hasta la temporada
            List<SerieApi> contenidoTotalSerie = new ArrayList<>();

            String serie1 = Util.URL_API + "?t=breaking+bad&season=1&apikey=" + Util.API_KEY;
           // String serie5 = Util.URL_API + "?t=breaking+bad&season=1&episode=1&apikey=" + Util.API_KEY;
            String serie4 = Util.URL_API + "?t=breaking+bad&season=2&apikey=" + Util.API_KEY;
            String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
            String serie3 = Util.URL_API + "?t=you&season=1&apikey=" + Util.API_KEY;

            SerieApi f = getContenidoSeries(serie1);
            SerieApi g = getContenidoSeries(serie2);
            SerieApi h = getContenidoSeries(serie3);
            SerieApi i = getContenidoSeries(serie4);
           // SerieApi j = getContenidoSeries(serie5);
            contenidoTotalSerie.add(f);
            contenidoTotalSerie.add(g);
            contenidoTotalSerie.add(h);
            contenidoTotalSerie.add(i);
            //contenidoTotalSerie.add(j);
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
                SerieApi s = om.readValue(json, SerieApi.class);
                return s;
            } catch (IOException e) {
                //log + tirar la excepcion
                e.printStackTrace();
                throw new RuntimeException("There was an error reading content", e);
            }
        }
}