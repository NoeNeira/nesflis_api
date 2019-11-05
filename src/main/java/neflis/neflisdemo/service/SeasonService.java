package neflis.neflisdemo.service;

import neflis.neflisdemo.model.EpisodeApi;
import neflis.neflisdemo.model.SeasonApi;
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
    public class SeasonService { // season service no se usa!! o si?,
        private List<SeasonApi> seasonList;
        private List<EpisodeApi> episodes;

        public void SeasonService(){
            if(this.seasonList == null){
                this.seasonList= cargarContenidos();}}

       public List<SeasonApi> contenidoPorEpisodio (String title, String season, String episode){
           return contenidoPorSeason(title, season).stream().filter(s->s.getEpisode().equals(episode)).collect(Collectors.toList());  }

       public List<SeasonApi> contenidoPorSeason(String title, String season){
           return contenidoPorTitulo(title).stream().filter(s-> s.getSeason().equals(season)).collect(Collectors.toList());
       }
       public List<SeasonApi> contenidoPorTitulo(String title) {
            //contenidos=contenidoStorage.contents();
        /*if (title == null) {return contenidos;
        } else {*/
            return cargarContenidos().stream().filter(s->s.getTitle().equals(title)).collect(Collectors.toList()
            );}

        public List<SeasonApi> cargarContenidos() {
            List<SeasonApi> contenidoTotalSerie = new ArrayList<>();

            String serie1 = Util.URL_API + "?t=breaking+bad&season=1&apikey=" + Util.API_KEY;
            String serie2 = Util.URL_API + "?t=stranger+things&&apikey=" + Util.API_KEY;
            String serie3 = Util.URL_API + "?t=you&season=1&apikey=" + Util.API_KEY;

            SeasonApi f = getContenidoSeries(serie1);
            SeasonApi g = getContenidoSeries(serie2);
            SeasonApi h = getContenidoSeries(serie3);

            contenidoTotalSerie.add(f);
            contenidoTotalSerie.add(g);
            contenidoTotalSerie.add(h);
            return contenidoTotalSerie;
        }
        private SeasonApi getContenidoSeries(String serie) {
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
                SeasonApi s = om.readValue(json, SeasonApi.class);
                return s;
            } catch (IOException e) {
                //log + tirar la excepcion
                e.printStackTrace();
                throw new RuntimeException("There was an error reading content", e);
            }
        }

    }
