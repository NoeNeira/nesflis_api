package neflis;

import neflis.neflisdemo.controller.UserController;
import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
import neflis.neflisdemo.service.UserService;
import neflis.neflisdemo.util.Util;
import okhttp3.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {
    private MockMvc mockMvc;
    UserController userController;
    UserService userService;
    UserApi yaz;
    UserApi noe;
    UserApi nadia;
    private TestRestTemplate restTemplate;
    @BeforeEach
    void setUp() {
        yaz = new UserApi("1L", "yaz");
        noe = new UserApi("2L", "noe");
        nadia = new UserApi("3L", "nadia");
    }

    @Test
    public void testFindById() {
        assertEquals("1L", yaz.getId());
    }

  /* @Test
   public void testAllUsers()
   {
       assertTrue(
               this.restTemplate
                       .getForObject("http://localhost:8080/" + "users/{id}", UserService.class)
                       .usuarios().size() == 1);
       System.out.println();
   }*/
    @Test //Solo anda si primero de corre la demoApp y dsp el test
    public void testContenidoVistoPorUsuario()
    throws IOException {
        OkHttpClient client = new OkHttpClient();
    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8080/" + "users/1L/watched" ).newBuilder();

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
}
    @Test //Solo anda si primero de corre la demoApp y dsp el test
    public void testContenidoRecomendadoPorUsuario()
            throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8080/" + "users/1L/featured" ).newBuilder();

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