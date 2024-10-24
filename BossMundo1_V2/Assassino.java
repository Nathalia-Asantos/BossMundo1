package BossMundo1_V2;

import BossMundo1_V2.enums.HabilidadesAssassino;
import BossMundo1_V2.interfaces.HabilidadeEspecial;

public class Assassino extends Mercenario {
    private HabilidadesAssassino habilidadeEspecial;
    public Assassino(String nome, int idade, double salarioBase, int tempoServico, int desempenho, HabilidadesAssassino habilidadeEspecial) {
        super(nome, idade, salarioBase, tempoServico, desempenho);
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public double calcularSalarioFinal() {
        double bonusDesempenho = getSalarioBase() * (getDesempenho() / 80.0);
        double bonusTempoServico = getSalarioBase() * (getTempoServico() / 15.0);
        return getSalarioBase() + bonusDesempenho + bonusTempoServico;
    }

    @Override
    public String exibeHabilidade() {
        return "A habilidade especial do assassino é" + habilidadeEspecial + "," + habilidadeEspecial.getDescricao();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Classe: Assassino, Habilidade: %s", habilidadeEspecial.getDescricao());
    }
}
