package br.com.fiap.haras_kzd.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ovinos")
public class Ovino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ovino;

    @Column(unique = true)
    private String numero_brinco;

    private LocalDate data_nascimento;
    private Double peso_nascimento;
    private Double peso_15d;
    private Double peso_30d;
    private Double peso_45d;
    private LocalDate data_vacina;

    @OneToMany(mappedBy = "ovino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Historico> historico = new ArrayList<>();

    public Ovino() {
    }

    public Ovino(Long id_ovino, String numero_brinco, LocalDate data_nascimento, Double peso_nascimento, Double peso_15d, Double peso_30d, Double peso_45d, LocalDate data_vacina, List<Historico> historico) {
        this.id_ovino = id_ovino;
        this.numero_brinco = numero_brinco;
        this.data_nascimento = data_nascimento;
        this.peso_nascimento = peso_nascimento;
        this.peso_15d = peso_15d;
        this.peso_30d = peso_30d;
        this.peso_45d = peso_45d;
        this.data_vacina = data_vacina;
        this.historico = historico;
    }

    public Long getId_ovino() {
        return id_ovino;
    }

    public void setId_ovino(Long id_ovino) {
        this.id_ovino = id_ovino;
    }

    public String getNumero_brinco() {
        return numero_brinco;
    }

    public void setNumero_brinco(String numero_brinco) {
        this.numero_brinco = numero_brinco;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Double getPeso_nascimento() {
        return peso_nascimento;
    }

    public void setPeso_nascimento(Double peso_nascimento) {
        this.peso_nascimento = peso_nascimento;
    }

    public Double getPeso_15d() {
        return peso_15d;
    }

    public void setPeso_15d(Double peso_15d) {
        this.peso_15d = peso_15d;
    }

    public Double getPeso_30d() {
        return peso_30d;
    }

    public void setPeso_30d(Double peso_30d) {
        this.peso_30d = peso_30d;
    }

    public Double getPeso_45d() {
        return peso_45d;
    }

    public void setPeso_45d(Double peso_45d) {
        this.peso_45d = peso_45d;
    }

    public LocalDate getData_vacina() {
        return data_vacina;
    }

    public void setData_vacina(LocalDate data_vacina) {
        this.data_vacina = data_vacina;
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }
}
