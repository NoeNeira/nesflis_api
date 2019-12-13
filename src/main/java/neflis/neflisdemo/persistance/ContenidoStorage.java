package neflis.neflisdemo.persistance;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import neflis.neflisdemo.model.Contenido;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ContenidoStorage {
    private ObjectMapper objectMapper;
    public ContenidoStorage(ObjectMapper objectMapper){this.objectMapper=objectMapper;}

     public List<Contenido> contents(){
        try { return objectMapper.readValue(
             new File("/home/yaz/neflis/src/main/resources/Contents.json") ,
                new TypeReference<List<Contenido>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);}}

     private String getContents()
    {
        final String uri = "http://www.omdbapi.com/?i=tt3896198&apikey=4823c028";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;

    }     }
    /*public void agregarContentss (List <ContenidoApi> contents){
        try {
            objectMapper.writeValue(
                    new File("src/main/resources/Contents.json"), contents);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);}}

        }*/