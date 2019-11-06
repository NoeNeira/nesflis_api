package neflis.neflisdemo.persistance;

import com.fasterxml.jackson.core.type.TypeReference;
import neflis.Contenido;
import neflis.neflisdemo.model.ContenidoApi;
import neflis.neflisdemo.utils.Sha1;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Component
public class ContenidoApiStorage {
    public ContenidoApiStorage contenidoApiStorage;
    private ObjectMapper objectMapper;
    private List<ContenidoApi> contenidos;
    public ContenidoApiStorage(ObjectMapper objectMapper){this.objectMapper=objectMapper;}

    public List<ContenidoApi> contents(){
        try { return objectMapper.readValue(
                new File("/home/yaz/neflis/src/main/resources/Contents.json") ,
                new TypeReference<List<ContenidoApi>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);}}

    private String getContents()
    {
        final String uri = "http://www.omdbapi.com/?i=tt3896198&apikey=4823c028";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;

    }

//***********************************************************************************************
   public Sha1 sha;
//
//    public String agregarId(){
//    String miShaEnString = miSha.toString();
//    contenido.setId(miShaEnString);
//    return contenido.getId();
//
//
//}
    public String agregarId(ContenidoApi contenido){
        return sha.generarId(contenido);
    }

    public void agregarContenido(ContenidoApi contenido){
        contenidos=contenidoApiStorage.contents();

        contenido.setId(agregarId(contenido));

        this.contenidos.add(contenido);
        this.contenidoApiStorage.agregarContenidoAArchivo(this.contenidos);
    }
//  TOMADO DE MASCOTA!!!!
    /*public Mascota agregarMascota(Mascota nuevaMascota){  //metodo para añadir una nueva mascota con POST
        mascotas=mascotaStorage.mascotas();

        //agregar id correlativo
        long count = mascotas.stream().count();
        int i=mascotas.stream().skip(count - 1).findFirst().get().getId();
        nuevaMascota.setId(i+1);

        this.mascotas.add(nuevaMascota);
        this.mascotaStorage.agregarMascotaAArchivo(this.mascotas);
        return nuevaMascota;
        //this.mascotaStorage.agregarMascotaAArchivo(nuevaMascota); //en vez de agregar el objeto mascota, agrego la lista de mascotas
    }*/

}
