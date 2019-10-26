package neflis.neflisdemo.persistance;

import com.fasterxml.jackson.core.type.TypeReference;
import neflis.neflisdemo.model.ContenidoApi;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Component
public class ContenidoApiStorage {
    private ObjectMapper objectMapper;

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

}
