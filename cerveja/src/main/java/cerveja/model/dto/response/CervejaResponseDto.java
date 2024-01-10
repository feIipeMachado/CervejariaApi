package cerveja.model.dto.response;

import cerveja.model.TipoCerveja;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaResponseDto {

    private String tipoCerveja;
    private BigDecimal valor;
}
