package BossMundo1_V2.enums;

import BossMundo1_V2.interfaces.HabilidadeEspecial;

public enum HabilidadesCavaleiro implements HabilidadeEspecial {
    ESCUDO_DEFLETOR,
    GOLPE_AVASSALADOR,
    RESISTENCIA_ABSOLUTA;

    @Override
    public String getDescricao() {
        switch (this) {
            case ESCUDO_DEFLETOR:
                return "Escudo Defletor reflete ataques inimigos.";
            case GOLPE_AVASSALADOR:
                return "Golpe Avassalador causa dano em área com impacto massivo.";
            case RESISTENCIA_ABSOLUTA:
                return "Resistência Absoluta aumenta a defesa drasticamente.";
            default:
                return "Habilidade desconhecida.";
        }
    }
}
