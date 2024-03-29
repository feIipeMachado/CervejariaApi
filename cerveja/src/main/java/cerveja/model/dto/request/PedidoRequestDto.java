package cerveja.model.dto.request;

import cerveja.model.entity.Cerveja;
import cerveja.model.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDto {

    private Long id;

    private Usuario usuario;

    private List<Cerveja> cervejas;

}
