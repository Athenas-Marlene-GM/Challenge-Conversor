import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetConversion {

    public String getBaseCode(int option){
        String baseCode = "";
        switch (option){
            case 1,2,3:
                baseCode = "USD";
                break;
            case 4,5,6:
                baseCode = "MXN";
                break;
            case 7,8,9:
                baseCode = "EUR";
                break;
            case 10,11,12:
                baseCode = "COP";
                break;
        }
        return  baseCode;
    }
    public String getTargetCode(int option){
        String targetCode = "";
        switch (option) {
            case 1, 7, 10:
                targetCode = "MXN";
                break;
            case 4, 8, 11:
                targetCode = "USD";
                break;
            case 2, 5, 12:
                targetCode = "EUR";
                break;
            case 3, 6, 9:
                targetCode = "COP";
                break;
        }
        return  targetCode;
    }
    public Conversion getConversion(String base_code, String target_code, Double amount){
        URI address = URI.create("https://v6.exchangerate-api.com/v6/9f08f4e6659a45f893d1128e/pair/"+ base_code + "/" + target_code + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Error.");
        }
    }

}
