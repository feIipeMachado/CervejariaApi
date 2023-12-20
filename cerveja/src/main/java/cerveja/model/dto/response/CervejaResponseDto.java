package cerveja.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaResponseDto {

    private String marca;
    private BigDecimal valor;
}
