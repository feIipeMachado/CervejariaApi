package cerveja.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaRequestDto {

    private String marca;
    private BigDecimal valor;
}
