package br.com.fiap.haras_kzd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vacinas")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idvacina;
    private String nome_vacina;
    private String lote_vacina;


    public Vacina() {
    }

    public Vacina(Long idvacina, String nome_vacina, String lote_vacina) {
        this.idvacina = idvacina;
        this.nome_vacina = nome_vacina;
        this.lote_vacina = lote_vacina;
    }

    public Long getIdvacina() {
        return idvacina;
    }

    public void setIdvacina(Long idvacina) {
        this.idvacina = idvacina;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getLote_vacina() {
        return lote_vacina;
    }

    public void setLote_vacina(String lote_vacina) {
        this.lote_vacina = lote_vacina;
    }
}
