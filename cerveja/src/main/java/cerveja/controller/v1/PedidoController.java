package cerveja.controller.v1;

import cerveja.model.dto.request.PedidoRequestDto;
import cerveja.service.PedidoService;
import cerveja.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/pedidos")
public class PedidoController {

    private PedidoService service;
    public PedidoController (PedidoService service) {
        this.service = service;
    }

//    @PostMapping
//    public ResponseEntity<Void> adicionarPedido(@RequestBody PedidoRequestDto pedido) {
//        service.adicionar(pedido);
//        //return ResponseEntity.created(null).build();
//    }

}
