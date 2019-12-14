package neflis;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContenidoControllerTest {
    // HACER BEFORE EACH CON SERVIDOR DE MENTIRA
    @Test //Solo anda si primero de corre la demoApp y dsp el test
    public void testContenidosTotales()
            throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8080/" + "contents" ).newBuilder();

        String url = urlBuilder.build().toString();
        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        try {response.code();

    } catch (NullPointerException e) {
     System.out.println("No anda el servicio");
    }

        assertThat(response.code(), equalTo(200));
    }}


