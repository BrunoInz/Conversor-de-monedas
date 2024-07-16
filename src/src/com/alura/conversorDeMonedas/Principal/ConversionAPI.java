package com.alura.conversorDeMonedas.Principal;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionAPI {
    //Setting URL
    static final String APIKey = "3246898874951c24f1f12df8";

    private static final String conversionURL = "https://v6.exchangerate-api.com/v6/" + APIKey + "/pair/";

    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(conversionURL + fromCurrency + "/" + toCurrency + "/" + amount)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() !=200) {
            throw new IOException("Error getting exchange rates ");
        }

        Gson gson = new Gson();
        ConversionRates conversionResult = gson.fromJson(response.body(), ConversionRates.class);

        return conversionResult.conversion_result();
    }
  }