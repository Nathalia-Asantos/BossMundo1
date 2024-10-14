package BossMundo1_V1;

public class Mercenario {
    private String nome;
    private int idade;
    private Classes classe;
    private double salarioBase;
    private int tempoServico;
    private int desempenho;


    public Mercenario(String nome, int idade, Classes classe, double salarioBase, int tempoServico, int desempenho) {
        this.nome = nome;
        this.idade = idade;
        this.classe = classe;
        this.salarioBase = salarioBase;
        this.tempoServico = tempoServico;
        this.desempenho = desempenho;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classes getClasse() {
        return classe;
    }

    public void setClasse(Classes classe) {
        this.classe = classe;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public int getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(int desempenho) {
        this.desempenho = desempenho;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Idade: " + idade +
                ", Classe: " + classe +
                ", Salario Base: " + salarioBase +
                ", Tempo de Servico:" + tempoServico +
                ", Desempenho: " + desempenho;
    }
}
