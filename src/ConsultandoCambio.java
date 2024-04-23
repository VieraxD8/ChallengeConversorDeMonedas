import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultandoCambio {

     Monedas obtenerTasasCambio(String iso){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ede6b93deadcef305042fbb1/latest/"+iso);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            ExchangeRateApi apiResponse  = gson.fromJson(response.body(), ExchangeRateApi.class);

            return apiResponse.getConversionRates();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
