package br.com.fiap.haras_kzd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfuncionario;

    @Enumerated(EnumType.STRING)
    private EnumFuncao funcao;

    private String nome;


    public Funcionario() {
    }

    public Funcionario(Long idfuncionario, EnumFuncao funcao, String nome) {
        this.idfuncionario = idfuncionario;
        this.funcao = funcao;
        this.nome = nome;
    }

    public Long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public EnumFuncao getFuncao() {
        return funcao;
    }

    public void setFuncao(EnumFuncao funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


