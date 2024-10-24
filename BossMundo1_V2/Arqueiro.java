package BossMundo1_V2;

import BossMundo1_V2.enums.HabilidadesArqueiro;


public class Arqueiro extends Mercenario {
    private HabilidadesArqueiro habilidadeEspecial;

    public Arqueiro(String nome, int idade, double salarioBase, int tempoServico, int desempenho, HabilidadesArqueiro habilidadeEspecial) {
        super(nome, idade, salarioBase, tempoServico, desempenho);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public double calcularSalarioFinal() {
        double bonusDesempenho = getSalarioBase() * (getDesempenho() / 65.0);
        double bonusTempoServico = getSalarioBase() * (getTempoServico() / 20.0);
        return getSalarioBase() + bonusDesempenho + bonusTempoServico;
    }

    public String exibeHabilidade() {
        return "A habilidade especial do Arqueiro é: " + habilidadeEspecial + ", "+ habilidadeEspecial.getDescricao();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Classe: Arqueiro, Habilidade: %s", habilidadeEspecial.getDescricao());
    }
}
