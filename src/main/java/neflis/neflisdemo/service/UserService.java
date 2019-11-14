package neflis.neflisdemo.service;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
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
public class UserService  {
    protected List<UserApi> usersList;
    public List<Contenido> contenidos;
    public ContenidoService contenidoService;

    public void UserService(){
        if(this.usersList == null){
            this.usersList= usuarios();}}


    public List<UserApi> usuariosPorIdContenidoVisto(String id){//Trae usuarios por id
        if(id==null){
        return usuarios() ;}
        else {return usuarios().stream().filter(userApi -> userApi.getId()
                .equals(id)).collect(Collectors.toList());
        }
    }

  /*  public List<UserApi> feature(){}
    public List<UserApi> generoMasVisto(String genre, String runtime){
        return contenidosVistosA().stream().filter()*/

    /*public Integer minVistosxGenero(String genre, String runtime){return
           contenidoPorRuntime(genre, runtime).stream().filter(c->c.getGenre()
                    .equals( genre ) ).mapToInt( c-> Integer.parseInt(c.cortarRuntime()))
                    .sum();}*/

    public List<Contenido> contenidoPorRuntime(String title, String genre, String runtime){
        return contenidoPorGenre(title, genre).stream().filter(c->c.getRuntime().equals(runtime)).collect(Collectors.toList());
    }
    public List<Contenido> contenidoPorGenre(String title, String genre){
        return contenidoPorTitle(title).stream().filter(c->c.getRuntime().equals(genre)).collect(Collectors.toList());
    }
    public List<Contenido> contenidoRuntime (String title, String runtime ){ return
        contenidoPorTitle(title).stream().filter(c->c.getRuntime().equals(runtime)).collect(Collectors.toList());}

    public List<Contenido> contenidoPorTitle( String title) { //Contenidos por genero
        //contenidos=contenidoStorage.contents();
        if (title == null) {
            return contenidosVistosA();
        } else {
        return contenidosVistosA().stream().filter(c -> c.getGenre().equals(title)).collect(Collectors.toList()
        ); }}

    public List<UserApi> usuarios() {
        List<UserApi> users = new ArrayList<>();

        UserApi yaz= new UserApi("1L", "yaz");
        UserApi noe = new UserApi("2L", "noe");
        UserApi nadia= new UserApi("3L", "nadia");

        users.add(yaz);
        users.add(noe);
        users.add(nadia);

        yaz.setContenidos(contenidosVistosA());


        //yaz.setContenidoRecomendado(contenidosNuevos());


    return users; }

    public List<Contenido> cargarContenidosRecomendados() { // Contenidos de series y peliculas
        List<Contenido> contenidoTotal= new ArrayList<>();
        //String movie1URL = Util.URL_API + "?t=brave+heart&apikey=" + Util.API_KEY;
        //String movie2URL = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
        String movie3URL = Util.URL_API + "?t=mask&apikey=" + Util.API_KEY;

        //Contenido c = getContenidoVisto(movie1URL);
        //Contenido d = getContenidoVisto(movie2URL);
        Contenido e = getContenidoVisto(movie3URL);

       // String serie1 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;
        String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
        String serie3 = Util.URL_API + "?t=you&apikey=" + Util.API_KEY;

        //Contenido f = getContenidoVisto(serie1);
        Contenido g = getContenidoVisto(serie2);
        Contenido h = getContenidoVisto(serie3);
        //contenidoTotal.add(f);
        contenidoTotal.add(g);
        contenidoTotal.add(h);
        //contenidoTotal.add(c);
        //contenidoTotal.add(d);
        contenidoTotal.add(e);
        g.getRuntime(); g.getGenre();
        h.getRuntime(); h.getGenre();
        e.getRuntime(); e.getGenre();

        return contenidoTotal;
    }


    public List<Contenido> contenidosVistosA(){
      List<Contenido>contenidoList= new ArrayList<>();
      String contenidoVisto1 = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
      String contenidoVisto2 = Util.URL_API + "?t=brave+heart&apikey=" + Util.API_KEY;
      String contenidoVisto3 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;

      /*String contenidoVisto4 = Util.URL_API + "?t=you&apikey=" + Util.API_KEY;
      String contenidoVisto5 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;*/
      Contenido a= getContenidoVisto(contenidoVisto1);
      Contenido b= getContenidoVisto(contenidoVisto2);
      Contenido c= getContenidoVisto(contenidoVisto3);
     /* Contenido d= getContenidoVisto(contenidoVisto4);
      Contenido e= getContenidoVisto(contenidoVisto5);*/
      contenidoList.add(a);
      contenidoList.add(b);
      contenidoList.add(c);
        /*a.getRuntime(); a.getGenre();
        b.getRuntime(); b.getGenre();
        c.getRuntime(); c.getGenre();*/
      return contenidoList;

    }
    private Contenido getContenidoVisto(String contenido) {
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

            CustomObjectMapper om = new CustomObjectMapper();
            Contenido s = om.readValue(json, Contenido.class);
            return s;
        } catch (IOException e) {
            //log + tirar la excepcion
            e.printStackTrace();
            throw new RuntimeException("There was an error reading content", e);
        }
    }
}



/*
    public List<UserApi> usuarios(){
            List<UserApi> usuariosLista = new ArrayList<>();
         String yaz= Util.URL_API + "?apikey=" + Util.API_KEY;
         String nadia= Util.URL_API + "?apikey=" + Util.API_KEY;
         String noe = Util.URL_API + "?apikey=" + Util.API_KEY;
        }*/

