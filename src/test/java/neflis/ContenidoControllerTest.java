package neflis;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContenidoControllerTest {



    @Test //Solo anda si primero de corre la demoApp y dsp el test
    public void whenGetRequestWithQueryParameter_thenCorrect()
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

        assertThat(response.code(), equalTo(200));
    }}


