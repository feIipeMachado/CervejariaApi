package cerveja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tipo_cerveja_tb")
@Data
public class TipoCerveja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nomeMarca;
    @Column
    private BigDecimal valor;


}
