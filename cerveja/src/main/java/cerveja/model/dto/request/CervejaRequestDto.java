package cerveja.model.dto.request;

import cerveja.model.TipoCerveja;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaRequestDto {

    private TipoCerveja tipoCerveja;
    private BigDecimal valor;
}
