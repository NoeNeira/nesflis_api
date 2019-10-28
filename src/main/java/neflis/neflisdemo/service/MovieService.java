package neflis.neflisdemo.service;

import neflis.neflisdemo.model.MovieApi;
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

@Service
public class MovieService {
   /* private List<MovieApi> movieApiList;
    public MovieService(){
        if(this.movieApiList == null){
            this.movieApiList= contenidoMovie();
        }
    }
    public List<MovieApi> contenidoMovie(){
    List<MovieApi> contenidoTotalMovie= new ArrayList<>();
    String movie1URL = Util.URL_API + "?t=brave+heart&apikey=" + Util.API_KEY;
    String movie2URL = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
    String movie3URL = Util.URL_API + "?t=mask&apikey=" + Util.API_KEY;


    MovieApi c = getContenidoMovie(movie1URL);
    MovieApi d = getContenidoMovie(movie2URL);
    MovieApi e = getContenidoMovie(movie3URL);
    contenidoTotalMovie.add(c);
    contenidoTotalMovie.add(d);
    contenidoTotalMovie.add(e);
    return contenidoTotalMovie;
}
    private MovieApi getContenidoMovie(String movie){
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
            MovieApi c = om.readValue(json, MovieApi.class);
            return c;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);

    }
    }*/
}
