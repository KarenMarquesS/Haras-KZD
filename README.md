# 🐑 Haras KZD - Sistema de Gestão de Ovinos

Sistema de gestão completo para controle de ovinos, vacinas, funcionários e histórico de atividades.

Agora execute a aplicação! ✅

**Acesse:** http://localhost:8080

---

## 📋 Tecnologias

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **Thymeleaf** (templates)
- **Bootstrap 5** (UI)
- **SQL Server** / **H2 Database**



### SQL Server (Produção)
- Requer SQL Server instalado e configurado
- Veja: `src/main/resources/GUIA_SQL_SERVER.md`
- Configure em `application.properties`

## 🏃 Executar a Aplicação

### Via IDE (IntelliJ/Eclipse)
- Execute a classe `HarasKzdApplication.java`

### Via Maven
```bash
mvn spring-boot:run
```

### Via JAR
```bash
mvn clean package
java -jar target/Haras_KZD-0.0.1-SNAPSHOT.jar
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/fiap/haras_kzd/
│   │   ├── controller/    # Controllers REST/MVC
│   │   ├── model/         # Entidades JPA
│   │   ├── repository/    # Repositórios Spring Data
│   │   └── config/        # Configurações
│   └── resources/
│       ├── templates/     # Templates Thymeleaf
│       
```

## 🎯 Funcionalidades

- ✅ Gestão de Ovinos (CRUD)
- ✅ Gestão de Vacinas
- ✅ Gestão de Funcionários
- ✅ Histórico de atividades
- ✅ Pesagem de animais
- ✅ Registro de vacinações
- ✅ Navegação intuitiva

## 📊 Dados de Exemplo

O arquivo `db.migration` contém dados iniciais:

- **6 Funcionários** (Tratadores, Zootecnistas, ADM)
- **5 Vacinas** (Raiva, Febre Aftosa, etc.)
- **25 Ovinos** com histórico de peso e vacinação


## 👨‍💻 Desenvolvedor

Sistema desenvolvido para gestão de rancho/ovinos.

---


### v0.0.1-SNAPSHOT
- Funcionalidades básicas de CRUD
- Integração com SQL Server 
- Interface web responsiva
- Dados de exemplo incluídos


