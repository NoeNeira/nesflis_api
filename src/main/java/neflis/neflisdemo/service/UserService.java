package neflis.neflisdemo.service;

import neflis.neflisdemo.model.UserApi;
import neflis.neflisdemo.util.Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {
    private List<UserApi> usersList;

    /*public void UserService(){
        if(this.users==null){
            this.users=usuarios();}}*/
    public List<UserApi> usuarios(){
      List<UserApi> users = new ArrayList<>();
        users.add(new UserApi(1L, "yaz"));
		users.add(new UserApi(2L, "nadia"));
		users.add(new UserApi(3L, "noe"));
    return users; }}



/*
    public List<UserApi> usuarios(){
            List<UserApi> usuariosLista = new ArrayList<>();
         String yaz= Util.URL_API + "?apikey=" + Util.API_KEY;
         String nadia= Util.URL_API + "?apikey=" + Util.API_KEY;
         String noe = Util.URL_API + "?apikey=" + Util.API_KEY;
        }*/

