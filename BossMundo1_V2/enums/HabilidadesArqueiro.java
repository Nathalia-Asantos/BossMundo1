package BossMundo1_V2.enums;

import BossMundo1_V2.interfaces.HabilidadeEspecial;

public enum HabilidadesArqueiro implements HabilidadeEspecial {
    FLECHA_ENVENENADA,
    FLECHADA,
    FURTIVIDADE;

    @Override
    public String getDescricao() {
        switch (this) {
            case FLECHA_ENVENENADA: return "Flecha envenenada causa dano contínuo.";
            case FLECHADA: return "Flechada é um tiro de longa distância.";
            case FURTIVIDADE: return "Furtividade permite ataques sem ser visto.";
            default: return "Habilidade desconhecida.";
        }
    }
}
