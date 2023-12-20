package cerveja.service;

import cerveja.repository.CervejaRepository;
import org.springframework.stereotype.Service;

@Service
public class CervejaService {

    private CervejaRepository repository;

    public CervejaService (CervejaRepository repository) {
        this.repository = repository;
    }
}
