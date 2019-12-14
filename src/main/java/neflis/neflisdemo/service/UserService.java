package neflis.neflisdemo.service;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
//import neflis.neflisdemo.persistance.UserRepository;
//import neflis.neflisdemo.persistance.UserRepository;
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
    //private UserRepository userRepository;
    private List<UserApi> usersList;
    //public UserService(UserStorage)
    /*public UserService(UserRepository userRepository){
        this.userRepository=userRepository;}*/

    public List<UserApi> getUsersList() {
        if(usersList == null) {
            usersList = new ArrayList<>();
        }
        return usersList;
    }
    public void UserService(){
        if(this.usersList == null){
            this.usersList= usuarios();}}

    /*public UserApi agregarUser(UserApi user){ return
            userRepository.save(user);
    }*/
    public List<UserApi> usuariosPorIdContenidoRecomendado(String id){ //Trae usuarios por id
        //usersList=userRepository.findAll();
        if(id==null){
            return usuariosContenidoRecomendado() ;}
        else {return usuariosContenidoRecomendado().stream().filter(userApi -> userApi.getId()
                .equals(id)).collect(Collectors.toList());
        }}
    public List<UserApi> usuariosPorId(String id){ //Trae usuarios por id
        //usersList=userRepository.findAll();
        if(id==null){
        return usuarios() ;}
        else {return usuarios().stream().filter(userApi -> userApi.getId()
                .equals(id)).collect(Collectors.toList());
        }
    }
    public List<UserApi> usuariosContenidoRecomendado(){
        List<UserApi> users = new ArrayList<>();
        UserApi yaz= new UserApi("1L", "yaz");
        UserApi noe = new UserApi("2L", "noe");
        UserApi nadia= new UserApi("3L", "nadia");

        users.add(yaz);
        users.add(noe);
        users.add(nadia);
        yaz.setContenidoRecomendado(cargarContenidosQueNoVio());

        return users; }

    public List<UserApi> usuarios() {
        List<UserApi> users = new ArrayList<>();
        UserApi yaz= new UserApi("1L", "yaz");
        UserApi noe = new UserApi("2L", "noe");
        UserApi nadia= new UserApi("3L", "nadia");

        users.add(yaz);
        users.add(noe);
        users.add(nadia);
        yaz.setContenidos(contenidosVistosA()); // el otro metodo, clase.

        return users; }

    public List<Contenido> cargarContenidosQueNoVio() { // Contenidos de series y peliculas
        List<Contenido> contenidoTotal= new ArrayList<>();
        String movie3URL = Util.URL_API + "?t=mask&apikey=" + Util.API_KEY;
        String serie2 = Util.URL_API + "?t=stranger+things&apikey=" + Util.API_KEY;
        String serie3 = Util.URL_API + "?t=you&apikey=" + Util.API_KEY;

        Contenido e = getContenidoVisto(movie3URL);
        Contenido g = getContenidoVisto(serie2);
        Contenido h = getContenidoVisto(serie3);

        contenidoTotal.add(g);
        contenidoTotal.add(h);
        contenidoTotal.add(e);

        return contenidoTotal;
    }

    public List<Contenido> contenidosVistosA(){
      List<Contenido>contenidoList= new ArrayList<>();
      String contenidoVisto1 = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
      String contenidoVisto2 = Util.URL_API + "?t=braveheart&apikey=" + Util.API_KEY;
      String contenidoVisto3 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;

      Contenido a= getContenidoVisto(contenidoVisto1);
      Contenido b= getContenidoVisto(contenidoVisto2);
      Contenido c= getContenidoVisto(contenidoVisto3);

      contenidoList.add(a);
      contenidoList.add(b);
      contenidoList.add(c);

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



