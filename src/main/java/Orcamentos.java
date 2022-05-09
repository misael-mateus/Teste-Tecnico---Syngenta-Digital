public interface Orcamentos {
    public float orcamentoRidgewood(TipoCliente tipoCliente, String dia1, String dia2, String dia3);

    public float orcamentoRidgewoodReward(String dia);

    public float orcamentoRidgewoodRegular(String dia);

    public float orcamentoBridgewood(TipoCliente tipoCliente, String dia1, String dia2, String dia3);

    public float orcamentoBridgewoodRegular(String dia);

    public float orcamentoBridgewoodReward(String dia);

    public float orcamentoLakewood(TipoCliente tipoCliente, String dia1, String dia2, String dia3);

    public float orcamentoLakewoodReward();

    public float orcamentoLakewoodRegular(String dia);
}