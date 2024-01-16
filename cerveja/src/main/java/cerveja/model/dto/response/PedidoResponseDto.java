package cerveja.model.dto.response;

import cerveja.model.entity.Cerveja;
import cerveja.model.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class PedidoResponseDto {

    private Usuario usuario;

    private List<Cerveja> cervejas;
}
