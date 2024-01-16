package cerveja.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pedido_tb")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    private Usuario usuario;
    @Column
    @OneToMany(mappedBy = "pedido")
    private List<Cerveja> cervejas;
}
