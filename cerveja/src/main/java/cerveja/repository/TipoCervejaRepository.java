package cerveja.repository;


import cerveja.model.TipoCerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCervejaRepository extends JpaRepository<TipoCerveja, Long> {
    public Optional<TipoCerveja> findByNomeMarca(String nome);
}
