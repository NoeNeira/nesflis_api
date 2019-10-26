package neflis.neflisdemo.service;

import neflis.neflisdemo.model.ContenidoApi;
import neflis.neflisdemo.persistance.ContenidoApiStorage;
import neflis.neflisdemo.utils.Sha1;


import java.util.List;

public class ContenidoApiService {
    public Sha1 miSha;
    public List<ContenidoApi> contenidos;
    private ContenidoApiStorage contenidoStorage;
    public ContenidoApi agregarContenido(ContenidoApi nuevoContenido){  //metodo para añadir una nueva mascota con POST
        contenidos=contenidoStorage.contenidos();

        //agregar id correlativo
        String miShaEnString=miSha.toString();
        nuevoContenido.setId(miShaEnString);



        this.contenidos.add(nuevoContenido);
        this.contenidoStorage.agregarContenidoAArchivo(this.contenidos);
        return nuevoContenido;

    }


}
