package cerveja.controller.v1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/health")
public class HealthCheckController {
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Cervejaria está aberta!");
    }
}
