package cerveja.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoRequestDto {

    private String username;

    private List<TiposCervejaPedidoRequestDto> tipos;

}
