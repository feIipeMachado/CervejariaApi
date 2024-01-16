package cerveja.controller.v1;

import cerveja.model.dto.request.CervejaRequestDto;
import cerveja.model.dto.response.CervejaResponseDto;
import cerveja.model.entity.Cerveja;
import cerveja.service.CervejaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("v1/cervejas")
public class CervejaController {

    private CervejaService service;
    public CervejaController(CervejaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CervejaResponseDto>> buscarTodosOsTiposDeCerveja() {
        return ResponseEntity.ok(this.service.buscarTodasAsCervejas());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Void> adicionarCerveja(@RequestBody CervejaRequestDto cerveja) {
        service.adicionar(cerveja);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{nomeMarca}")
    public ResponseEntity<CervejaResponseDto> removerCerveja(@PathVariable("nomeMarca") String nomeMarca) {
        return ResponseEntity.ok(service.removerCervejaPorNomeMarca(nomeMarca));
    }
    @PutMapping("/{nomeMarca}")
    public ResponseEntity<Void> alterarValorTipoCerveja(@PathVariable("nomeMarca") String nomeMarca,
                                                                         @RequestBody BigDecimal valor) {
        Cerveja tipoCervejaAlterado = service.alterarValor(nomeMarca, valor);
        return ResponseEntity.noContent().build();
    }


}
