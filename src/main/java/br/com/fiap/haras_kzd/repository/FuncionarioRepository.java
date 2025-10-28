package br.com.fiap.haras_kzd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Funcionario extends JpaRepository<Funcionario, Long> {
}
