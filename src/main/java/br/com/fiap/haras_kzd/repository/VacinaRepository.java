package br.com.fiap.haras_kzd.repository;

import br.com.fiap.haras_kzd.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
