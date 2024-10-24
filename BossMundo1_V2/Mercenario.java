package BossMundo1_V2;

import BossMundo1_V2.enums.HabilidadesArqueiro;
import BossMundo1_V2.interfaces.HabilidadeEspecial;

public abstract class Mercenario {
    private String nome;
    private int idade;
    private double salarioBase;
    private int tempoServico;
    private int desempenho;

    public Mercenario(String nome, int idade, double salarioBase, int tempoServico, int desempenho) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.tempoServico = tempoServico;
        this.desempenho = desempenho;
    }

    public abstract double calcularSalarioFinal();

    public abstract String exibeHabilidade();

    public String toString() {
        return String.format("Nome: %s, Idade: %d, Salário Base: %.2f, Tempo de Serviço: %d, Desempenho: %d",
                nome, idade, salarioBase, tempoServico, desempenho);
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getSalarioBase() { return salarioBase; }
    public int getTempoServico() { return tempoServico; }
    public int getDesempenho() { return desempenho; }
}


