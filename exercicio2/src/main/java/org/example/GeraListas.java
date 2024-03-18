package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GeraListas {
    private String url;
    private String lista;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLista() {
        return lista;
    }

    public GeraListas(String url) {
        this.url = url;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public void geraLista() throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        setLista(response.body());
    }
}
