package cerveja.repository;

import cerveja.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

    public Optional<Cerveja> findByMarca(String marca);

    public Optional<Cerveja> findByValor(BigDecimal valor);
}
