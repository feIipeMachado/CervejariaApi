package cerveja.model.dto.request;

import lombok.Data;

@Data
public class TiposCervejaPedidoRequestDto {

    private String nomeTipo;
    private int quantidade;

}
