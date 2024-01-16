package cerveja.model.dto.converter;

import cerveja.model.dto.request.PedidoRequestDto;
import cerveja.model.dto.request.UsuarioRequestDto;
import cerveja.model.dto.response.PedidoResponseDto;
import cerveja.model.dto.response.UsuarioResponseDto;
import cerveja.model.entity.Pedido;
import cerveja.model.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PedidoConverter {
    public static Pedido converterDtoPraEntidade (PedidoRequestDto dto) {
        Pedido pedidoEntidade = new Pedido();
        pedidoEntidade.setUsuario(dto.getUsuario());
        pedidoEntidade.setCervejas(dto.getCervejas());
        return pedidoEntidade;
    }

    public static PedidoResponseDto converterEntidadePraDto (Pedido entidade) {
        PedidoResponseDto pedidoResponse = new PedidoResponseDto();
        pedidoResponse.setUsuario(entidade.getUsuario());
        pedidoResponse.setCervejas(entidade.getCervejas());

        return pedidoResponse;
    }

    public static List<PedidoResponseDto> converterListaEntidadePraDto (List<Pedido> listaPedidos) {
        List<PedidoResponseDto> listaPedidoResponseDto = new ArrayList<>();
        for (Pedido u : listaPedidos) {
            listaPedidoResponseDto.add(converterEntidadePraDto(u));
        }

        return listaPedidoResponseDto;
    }
}
