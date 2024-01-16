package cerveja.repository;

import cerveja.model.entity.Cerveja;
import cerveja.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

    public Optional<Cerveja> findByNomeMarca(String nomeMarca);
}
