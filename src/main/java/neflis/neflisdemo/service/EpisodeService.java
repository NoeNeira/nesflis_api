package neflis.neflisdemo.service;

import neflis.neflisdemo.model.EpisodeApi;
import neflis.neflisdemo.model.SerieApi;
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
public class EpisodeService {
    //private List<SerieApi> serieList;
    private List<EpisodeApi> episodes;
    private SerieService serieService;

    public void EpisodeService(){
            this.episodes= cargarContenidos();}

    public List<EpisodeApi> episodes(){
        return episodes.stream().filter(e->e.getEpisode().equals(episodes)).collect(Collectors.toList());

    }
    public List<EpisodeApi> contenidoEpisodio(String episode){// Contenidos con muchos filtros. A REVISAR!!
        return cargarContenidos().stream().filter(e->e.getEpisode().equals(episode)).collect(Collectors.toList());
    }
    public List<EpisodeApi> contenidoPorEpisodio(String title, String season, String episode){
        return contenidoPorSeason(title, season).stream().filter(s->s.getEpisode().equals(episode)).collect(Collectors.toList());
    }
    public List<EpisodeApi> contenidoPorSeason(String title, String season) {
        return contenidoPorTitulo(title).stream().filter(s -> s.getSeason().equals(season)).collect(Collectors.toList());
    }
    public List<EpisodeApi> contenidoPorTitulo (String title){
        return cargarContenidos().stream().filter(s->s.getTitle().equals(title)).collect(Collectors.toList());

    }
        public List<EpisodeApi> cargarContenidos() {
            List<EpisodeApi> contenidoTotalSerie = new ArrayList<>();

            String serie1 = Util.URL_API + "?t=breaking+bad&season=1&episode=1&apikey=" + Util.API_KEY;
            String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
            String serie3 = Util.URL_API + "?t=you&season=1&apikey=" + Util.API_KEY;

            EpisodeApi f = getContenidoSeries(serie1);
            EpisodeApi g = getContenidoSeries(serie2);
            EpisodeApi h = getContenidoSeries(serie3);

            contenidoTotalSerie.add(f);
            contenidoTotalSerie.add(g);
            contenidoTotalSerie.add(h);
            return contenidoTotalSerie;
        }
        private EpisodeApi getContenidoSeries(String episode) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(episode)
                    .get()
                    .build();
            Call call = client.newCall(request);
            Response response = null;
            try {
                response = call.execute();
                String json = response.body().string();

                CustomObjectMapper om = new CustomObjectMapper();
                EpisodeApi s = om.readValue(json, EpisodeApi.class);
                return s;
            } catch (IOException e) {
                //log + tirar la excepcion
                e.printStackTrace();
                throw new RuntimeException("There was an error reading content", e);
            }
        }
    }

