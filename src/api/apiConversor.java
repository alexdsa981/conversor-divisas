package api;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class apiConversor {

    public recordConversor conversionDivisa (String cod_divisaEntrada, String cod_divisaSalida) {
        String key = "4010c37401902c7abb5d52dd";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + cod_divisaEntrada + "/" + cod_divisaSalida);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        {
            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), recordConversor.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
