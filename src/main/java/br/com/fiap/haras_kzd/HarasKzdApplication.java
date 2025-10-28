package br.com.fiap.haras_kzd;

import br.com.fiap.haras_kzd.model.EnumFuncao;
import br.com.fiap.haras_kzd.model.Funcionario;
import br.com.fiap.haras_kzd.model.Ovino;
import br.com.fiap.haras_kzd.model.Vacina;
import br.com.fiap.haras_kzd.repository.FuncionarioRepository;
import br.com.fiap.haras_kzd.repository.OvinoRepository;
import br.com.fiap.haras_kzd.repository.VacinaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HarasKzdApplication {

    public static void main(String[] args) {
        SpringApplication.run(HarasKzdApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(FuncionarioRepository funcionarioRepository,
                               VacinaRepository vacinaRepository,
                               OvinoRepository ovinoRepository) {
        return args -> {
            if (funcionarioRepository.count() == 0) {
                funcionarioRepository.save(new Funcionario(null, EnumFuncao.TRATADOR, "João Silva"));
                funcionarioRepository.save(new Funcionario(null, EnumFuncao.ZOOTECNISTA, "Ana Costa"));
                funcionarioRepository.save(new Funcionario(null, EnumFuncao.ADMINISTRADOR, "Carlos Ferreira"));
            }

            if (vacinaRepository.count() == 0) {
                vacinaRepository.save(new Vacina(null, "Raiva Ovina", "LOTE-2025-001"));
                vacinaRepository.save(new Vacina(null, "Febre Aftosa", "LOTE-2025-002"));
                vacinaRepository.save(new Vacina(null, "Clostridioses", "LOTE-2025-003"));
            }

            if (ovinoRepository.count() == 0) {
                ovinoRepository.save(new Ovino(null, "001", LocalDate.of(2024, 3, 15), 4.5, 6.2, 8.5, 12.3, LocalDate.of(2024, 5, 10), null));
                ovinoRepository.save(new Ovino(null, "002", LocalDate.of(2024, 4, 1), 5.0, 7.0, 9.5, 13.8, LocalDate.of(2024, 6, 1), null));
                ovinoRepository.save(new Ovino(null, "003", LocalDate.of(2024, 5, 10), 4.7, 6.8, 9.2, 13.4, LocalDate.of(2024, 7, 5), null));
            }
        };
    }

}
