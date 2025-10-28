package br.com.fiap.haras_kzd.repository;

import br.com.fiap.haras_kzd.model.Ovino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OvinoRepository extends JpaRepository<Ovino, Long> {
    @Query("select o from Ovino o where o.numero_brinco = :numeroBrinco")
    Optional<Ovino> findByNumeroBrinco(@Param("numeroBrinco") String numeroBrinco);

}
