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
    private UserController userController;
    private UserService userService;
    private UserApi userApi;
    UserApi yaz;
    UserApi noe;
    UserApi nadia;

    @BeforeEach
    void setUp() {
        yaz = new UserApi("1L", "yaz");
        noe = new UserApi("2L", "noe");
        nadia = new UserApi("3L", "nadia");
    }

   /* @Before
    public void initController(){
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }*/

    @Test
    public void testFindById() {
        // given
        assertEquals("1L", yaz.getId());
    }
    /*@Test
    public void testGetUsuarios(){
        List<Contenido> contenidoList= new ArrayList<>();
        String contenidoVisto1 = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
        String contenidoVisto2 = Util.URL_API + "?t=braveheart&apikey=" + Util.API_KEY;
        String contenidoVisto3 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;
        yaz.setContenidos(contenidoList);
        assertEquals(contenidoList, userService.usuarios());

    }*/

    /*@Test
    public void testUser()
            throws Exception {
        {
            //private MockMvc mockMvc;
            private UserController userController;
            private UserService userService;
            private UserApi userApi;
            UserApi yaz;
            UserApi noe;
            UserApi nadia;

            @BeforeEach
            void setUp () {
            yaz = new UserApi("1L", "yaz");
            noe = new UserApi("2L", "noe");
            nadia = new UserApi("3L", "nadia");
        }*/

   /* @Before
    public void initController(){
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }*
    /*@Test
    public void testGetUsuarios(){
        List<Contenido> contenidoList= new ArrayList<>();
        String contenidoVisto1 = Util.URL_API + "?t=titanic&apikey=" + Util.API_KEY;
        String contenidoVisto2 = Util.URL_API + "?t=braveheart&apikey=" + Util.API_KEY;
        String contenidoVisto3 = Util.URL_API + "?t=breaking+bad&apikey=" + Util.API_KEY;
        yaz.setContenidos(contenidoList);
        assertEquals(contenidoList, userService.usuarios());

    }*/

    @Test //Solo anda si primero de corre la demoApp y dsp el test
    public void whenGetRequestWithQueryParameter_thenCorrect()
    throws IOException {
        OkHttpClient client = new OkHttpClient();
    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://localhost:8080/" + "users/1L?watched" ).newBuilder();
        //urlBuilder.addQueryParameter("id", "1L");
        //urlBuilder.addQueryParameter("watched", "watched");
    String url = urlBuilder.build().toString();
    System.out.println(url);
    Request request = new Request.Builder()
            .url(url)
            .build();
    Call call = client.newCall(request);
    Response response = call.execute();

    assertThat(response.code(), equalTo(200));
}}