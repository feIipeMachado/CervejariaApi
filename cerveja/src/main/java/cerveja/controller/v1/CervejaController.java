package cerveja.controller.v1;

import cerveja.model.TipoCerveja;
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

    @GetMapping("/tipoCervejas")
    public ResponseEntity<List<TipoCerveja>> buscarTodosOsTiposDeCerveja() {
        return ResponseEntity.ok(this.service.buscarTodosTiposDeCerveja());
    }

    @PostMapping("/tipoCervejas/adicionar")
    public ResponseEntity<Void> adicionarTipoCerveja(@RequestBody TipoCerveja tipoCerveja) {
        service.adicionarTipoCerveja(tipoCerveja);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/tipoCervejas/{nomeMarca}")
    public ResponseEntity<TipoCerveja> removerTipoCerveja(@PathVariable("nomeMarca") String nomeMarca) {
        return ResponseEntity.ok(service.removerTipoCervejaPorNomeMarca(nomeMarca));
    }
    @PutMapping("/tipoCervejas/{nomeMarca}")
    public ResponseEntity<Void> alterarValorTipoCerveja(@PathVariable("nomeMarca") String nomeMarca,
                                                                         @RequestBody BigDecimal valor) {
        TipoCerveja tipoCervejaAlterado = service.alterarValor(nomeMarca, valor);
        return ResponseEntity.noContent().build();
    }


}
