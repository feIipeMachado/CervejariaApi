package cerveja.controller;

import cerveja.service.CervejaService;
import org.springframework.stereotype.Controller;

@Controller
public class CervejaController {

    private CervejaService service;
    public CervejaController(CervejaService service) {
        this.service = service;
    }


}
