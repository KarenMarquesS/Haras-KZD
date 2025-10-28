package br.com.fiap.haras_kzd.model;

public enum EnumFuncao {
    TRATADOR("Tratador"),
    ADMINISTRADOR("Administrador"),
    ZOOTECNISTA("Zootecnista");

    private final String descricao;

    private EnumFuncao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
