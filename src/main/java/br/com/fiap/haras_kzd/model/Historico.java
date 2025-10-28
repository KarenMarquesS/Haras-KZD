package br.com.fiap.haras_kzd.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historicos")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumAcao acao;

    private LocalDateTime dataHora;

    // peso registrado (quando for pesagem)
    private Double pesoRegistrado;

    // relacionamento com vacina (quando for vacinação)
    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina;

    // funcionário que executou a ação
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "ovino_id")
    private Ovino ovino;

    private String observacao;

    public Historico() {
    }

    public Historico(Long id, EnumAcao acao, LocalDateTime dataHora, Double pesoRegistrado, Vacina vacina, Funcionario funcionario, Ovino ovino, String observacao) {
        this.id = id;
        this.acao = acao;
        this.dataHora = dataHora;
        this.pesoRegistrado = pesoRegistrado;
        this.vacina = vacina;
        this.funcionario = funcionario;
        this.ovino = ovino;
        this.observacao = observacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumAcao getAcao() {
        return acao;
    }

    public void setAcao(EnumAcao acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getPesoRegistrado() {
        return pesoRegistrado;
    }

    public void setPesoRegistrado(Double pesoRegistrado) {
        this.pesoRegistrado = pesoRegistrado;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Ovino getOvino() {
        return ovino;
    }

    public void setOvino(Ovino ovino) {
        this.ovino = ovino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
