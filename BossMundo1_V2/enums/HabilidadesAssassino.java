package BossMundo1_V2.enums;

import BossMundo1_V2.interfaces.HabilidadeEspecial;

public enum HabilidadesAssassino implements HabilidadeEspecial {
    GOLPE_MORTAL,
    INVISIBILIDADE,
    LAMINA_OCULTA;

    @Override
    public String getDescricao() {
        switch (this) {
            case GOLPE_MORTAL: return "Golpe Mortal causa dano massivo.";
            case INVISIBILIDADE: return "Invisibilidade permite se esconder.";
            case LAMINA_OCULTA: return "Lâmina Oculta causa dano rápido.";
            default: return "Habilidade desconhecida.";
        }
    }
}
