package cerveja.integration;

import cerveja.integration.response.WeatherResponse;
import cerveja.integration.service.TemperaturaIntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/weather")
public class POConceptTemperaturaController {

    private TemperaturaIntegrationService service;

    public POConceptTemperaturaController(TemperaturaIntegrationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<WeatherResponse> buscarTemperaturaNoServicoExterno() {
        WeatherResponse temperaturaBuscadaServicoExterno =
                this.service.buscarTemperatura();
        return ResponseEntity.ok(temperaturaBuscadaServicoExterno);
    }
}
