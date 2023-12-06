package cerveja.integration.service;

import cerveja.integration.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TemperaturaIntegrationService {

    private final RestTemplate restTemplate;

    @Value("${weather-api}")
    private String uri;

    public TemperaturaIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WeatherResponse buscarTemperatura() {
        String urlCompleta = this.uri;
        WeatherResponse response = this.restTemplate.getForObject(urlCompleta, WeatherResponse.class);
        return response;
    }
}
