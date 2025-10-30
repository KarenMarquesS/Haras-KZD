package br.com.fiap.haras_kzd.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.sql.init.mode:never}")
    private String sqlInitMode;

    @PostConstruct
    public void init() {
        try {
            logger.info("Verificando se os dados iniciais já foram carregados...");
            logger.info("Modo de inicialização SQL: {}", sqlInitMode);
            
            // Verifica se já existem dados
            Long funcionarioCount = 0L;
            try {
                funcionarioCount = entityManager.createQuery("SELECT COUNT(f) FROM Funcionario f", Long.class)
                        .getSingleResult();
            } catch (Exception e) {
                logger.warn("Não foi possível verificar dados existentes: {}", e.getMessage());
            }

            if (funcionarioCount == 0 && "always".equals(sqlInitMode)) {
                logger.info("Carregando dados iniciais do arquivo imports.sql...");
                
                try (Connection connection = dataSource.getConnection()) {
                    ClassPathResource resource = new ClassPathResource("imports.sql");
                    ScriptUtils.executeSqlScript(connection, resource);
                    logger.info("Dados iniciais carregados com sucesso!");
                } catch (Exception e) {
                    logger.error("Erro ao executar imports.sql: {}", e.getMessage());
                }
            } else if (funcionarioCount > 0) {
                logger.info("Dados iniciais já existem. Pulando importação. ({} funcionários encontrados)", funcionarioCount);
            } else {
                logger.info("Modo de inicialização está definido como 'never'. Importação não será executada.");
            }
        } catch (Exception e) {
            logger.error("Erro ao inicializar dados: {}", e.getMessage(), e);
        }
    }
}

