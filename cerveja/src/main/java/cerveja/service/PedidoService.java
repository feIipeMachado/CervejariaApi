package cerveja.service;

import cerveja.model.dto.request.PedidoRequestDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {

    private UsuarioService usuarioService;

    public PedidoService (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

//    public BigDecimal adicionar(PedidoRequestDto pedido) {
//        // TODO Fazer verificações
//        String usuarioPedido = pedido.getUsername();
//        usuarioService.
//
//
//    }


}
