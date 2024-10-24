package BossMundo1_V2;

import BossMundo1_V2.enums.HabilidadesCavaleiro;

public class Cavaleiro extends Mercenario {
    private HabilidadesCavaleiro habilidadeEspecial;
    public Cavaleiro(String nome, int idade, double salarioBase, int tempoServico, int desempenho, HabilidadesCavaleiro habilidadeEspecial) {
        super(nome, idade, salarioBase, tempoServico, desempenho);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public double calcularSalarioFinal() {
        double bonusDesempenho = getSalarioBase() * (getDesempenho() / 90.0);
        double bonusTempoServico = getSalarioBase() * (getTempoServico() / 25.0);
        return getSalarioBase() + bonusDesempenho + bonusTempoServico;
    }

    @Override
    public String exibeHabilidade() {
        return "A habilidade especial deste Cavaleiro é" + habilidadeEspecial + ", " + habilidadeEspecial.getDescricao();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Classe: Cavaleiro, Habilidade: %s", habilidadeEspecial.getDescricao());
    }
}
