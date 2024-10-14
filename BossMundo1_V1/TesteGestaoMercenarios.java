package BossMundo1_V1;

public class TesteGestaoMercenarios {
    public static void main(String[] args) {

        // Teste: Cadastro de Mercenários
        System.out.println("==== Teste: As Aventuras dos Novos de Mercenários ====");
        cadastrarMercenario("Arthur", 30, "CAVALEIRO", 2000.0, 5, 4);
        cadastrarMercenario("Legolas", 25, "ARQUEIRO", 1800.0, 3, 5);
        cadastrarMercenario("Gandalf", 50, "MAGO", 3000.0, 10, 5);
        cadastrarMercenario("Assassino", 28, "jAVENGER", 2200.0, 7, 3);

        // Teste: Listagem de Mercenários
        System.out.println("\n==== Teste: A Lista de Mercenários ====");
        GestaoMercenarios.listarMercenarios();

        // Teste: Buscar Mercenário
        System.out.println("\n==== Teste: Em Busca de Mercenários ====");
        buscarMercenario("Legolas");
        buscarMercenario("Gandalf");
        buscarMercenario("NãoExistente");

        // Teste: Atualização de Mercenário
        System.out.println("\n==== Teste: A Evolução dos Mercenários ====");
        atualizarMercenario(1, "Legolas Atualizado", 26, "ARQUEIRO", 1900.0, 4, 5);
        atualizarMercenario(5, "Mercenario Inexistente", 50, "CAVALEIRO", 2500.0, 5, 5);

        // Teste: Filtrar Mercenários por Classe
        System.out.println("\n==== Teste: Os testes para Mercenários (Por Classe) ====");
        filtraMercenariosPorClasse("CAVALEIRO");
        filtraMercenariosPorClasse("Mago");
        filtraMercenariosPorClasse("jAVENGERS");

        // Teste: Remoção de Mercenário
        System.out.println("\n==== Teste: A Remoção de Mercenários ====");
        removerMercenario(0);
        removerMercenario(5);

        // Teste: Listagem após remoção
        System.out.println("\n ==== Os Últimos dos Mercenários ====");
        GestaoMercenarios.listarMercenarios();

    }

    private static void cadastrarMercenario(String nome, int idade, String classe, double salarioBase, int tempoServico, int desempenho) {
        try {
            Classes classeEnum = Classes.valueOf(classe.toUpperCase());
            Mercenario mercenario = new Mercenario(nome, idade, classeEnum, salarioBase, tempoServico, desempenho);
            GestaoMercenarios.mercenarios.add(mercenario);
            System.out.println("Mercenário " + nome + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Classe inválida: " + classe);
        }
    }

    private static void buscarMercenario(String nome) {
        boolean encontrado = false;
        for (Mercenario mercenario : GestaoMercenarios.mercenarios) {
            if (nome.equalsIgnoreCase(mercenario.getNome())) {
                System.out.println("Mercenário encontrado: " + mercenario);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Mercenário " + nome + " não encontrado.");
        }
    }

    private static void atualizarMercenario(int id, String novoNome, int novaIdade, String novaClasse, double novoSalarioBase, int novoTempoServico, int novoDesempenho) {
        try {
            if (id >= 0 && id < GestaoMercenarios.mercenarios.size()) {
                Classes novaClasseEnum = Classes.valueOf(novaClasse.toUpperCase());
                Mercenario mercenarioAtualizado = new Mercenario(novoNome, novaIdade, novaClasseEnum, novoSalarioBase, novoTempoServico, novoDesempenho);
                GestaoMercenarios.mercenarios.set(id, mercenarioAtualizado);
                System.out.println("Mercenário atualizado com sucesso!");
            } else {
                System.out.println("ID do mercenário inválido.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Classe inválida: " + novaClasse);
        }
    }

    private static void filtraMercenariosPorClasse(String classe) {
        boolean encontrado = false;
        try {
            Classes classeEnum = Classes.valueOf(classe.toUpperCase());
            for (Mercenario mercenario : GestaoMercenarios.mercenarios) {
                if (classeEnum.equals(mercenario.getClasse())) {
                    System.out.println("Mercenário encontrado: " + mercenario);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum mercenário encontrado para a classe: " + classe);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Classe inválida: " + classe);
        }
    }

    private static void removerMercenario(int id) {
        if (id >= 0 && id < GestaoMercenarios.mercenarios.size()) {
            GestaoMercenarios.mercenarios.remove(id);
            System.out.println("Mercenário removido com sucesso!");
        } else {
            System.out.println("ID inválido. Não foi possível remover o mercenário.");
        }
    }
}
