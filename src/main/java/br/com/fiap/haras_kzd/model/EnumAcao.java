package br.com.fiap.haras_kzd.model;

public enum EnumAcao {
    PESAGEM("Pesagem"),
    VACINACAO(""),
    MANEJO("");

    private final String descricao;

    private EnumAcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
