package BossMundo1_V2.enums;

import BossMundo1_V2.interfaces.HabilidadeEspecial;

public enum HabilidadesMago implements HabilidadeEspecial {
    BOLA_DE_FOGO,
    ESCUDO_MAGICO,
    INVOCACAO_ELEMENTAL;

    @Override
    public String getDescricao() {
        switch (this) {
            case BOLA_DE_FOGO:
                return "Bola de Fogo incinera os inimigos com chamas intensas.";
            case ESCUDO_MAGICO:
                return "Escudo Mágico absorve dano mágico e físico.";
            case INVOCACAO_ELEMENTAL:
                return "Invocação Elemental traz criaturas poderosas para a batalha.";
            default:
                return "Habilidade desconhecida.";
        }
    }
}

