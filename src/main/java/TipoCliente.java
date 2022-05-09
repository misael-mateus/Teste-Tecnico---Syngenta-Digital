public enum TipoCliente {
    REGULAR("Regular"),REWARD("Reward");
    private String descricao;

    TipoCliente(String descricao) {
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
