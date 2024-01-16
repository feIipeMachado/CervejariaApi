package cerveja.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaRequestDto {

    private String nomeMarca;
    private BigDecimal valor;
}
