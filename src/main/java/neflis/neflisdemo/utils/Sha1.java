package neflis.neflisdemo.utils;

import neflis.neflisdemo.model.ContenidoApi;

import java.math.BigInteger;
import java.security.MessageDigest;



public class Sha1 {
    private ContenidoApi contenido;
    public String generarId(ContenidoApi contenido) {

        String value = contenido.toString();

        String sha1 = "";

        // With the java libraries
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            return sha1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
