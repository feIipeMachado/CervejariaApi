package cerveja.controller.v1;

import cerveja.model.dto.request.PedidoRequestDto;
import cerveja.model.dto.response.PedidoResponseDto;
import cerveja.model.dto.response.UsuarioResponseDto;
import cerveja.model.entity.Cerveja;
import cerveja.model.entity.Pedido;
import cerveja.service.PedidoService;
import cerveja.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("v1/pedidos")
public class PedidoController {

    private PedidoService service;
    public PedidoController (PedidoService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<BigDecimal> calcularValor(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(this.service.adicionar(pedido));
    }


}
