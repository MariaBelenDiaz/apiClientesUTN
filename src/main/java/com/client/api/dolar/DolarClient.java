package com.client.api.dolar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class DolarClient {

    private final RestClient dolarClient = RestClient.create();

    @Value("${dolar.api.url}")
    private String dolarUrl;

    public Dolar getDolar() {

        return dolarClient.get()
                .uri(dolarUrl)
                .accept(APPLICATION_JSON)
                .retrieve()
                .body(Dolar.class);
    }
}