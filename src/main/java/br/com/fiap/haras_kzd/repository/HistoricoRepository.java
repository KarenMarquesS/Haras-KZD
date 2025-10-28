package br.com.fiap.haras_kzd.repository;

import br.com.fiap.haras_kzd.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
