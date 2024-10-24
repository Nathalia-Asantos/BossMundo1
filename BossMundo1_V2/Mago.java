package BossMundo1_V2;

import BossMundo1_V2.enums.HabilidadesMago;

public class Mago extends Mercenario {
    private HabilidadesMago habilidadeEspecial;
    public Mago(String nome, int idade, double salarioBase, int tempoServico, int desempenho, HabilidadesMago habilidadeEspecial) {
        super(nome, idade, salarioBase, tempoServico, desempenho);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public double calcularSalarioFinal() {
        double bonusDesempenho = getSalarioBase() * (getDesempenho() / 120.0);
        double bonusTempoServico = getSalarioBase() * (getTempoServico() / 60.0);
        return getSalarioBase() + bonusDesempenho + bonusTempoServico;
    }

    @Override
    public String exibeHabilidade() {
        return "A habilidade especial deste Mago é" + habilidadeEspecial + ", " + habilidadeEspecial.getDescricao();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Classe: Mago, Habilidade: %s", habilidadeEspecial.getDescricao());
    }
}