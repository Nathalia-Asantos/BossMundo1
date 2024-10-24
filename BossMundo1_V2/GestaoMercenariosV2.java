package BossMundo1_V2;

import BossMundo1_V2.enums.*;

import java.util.*;

public class GestaoMercenariosV2 {
    static List<Mercenario> mercenarios = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner menu = new Scanner(System.in);
            int opcao = 0;

            do {
                System.out.println("""
                        \n==== Sistema de Gestão de Mercenários ====
                        1. Adicionar Mercenário
                        2. Atualizar Mercenário
                        3. Remover Mercenários
                        4. Listar Mercenários
                        5. Buscar Mercenário por nome
                        6. Filtrar Mercenários por classe
                        7. Relatório de distribuição por classe
                        8. Sair
                        """);
                System.out.println("Escolha uma das opções acima:");
                try {
                    opcao = menu.nextInt();
                    switch (opcao) {
                        case 1 -> cadastroMercenario();
                        case 2 -> atualizarMercenario();
                        case 3 -> removerMercenario();
                        case 4 -> listarMercenarios();
                        case 5 -> buscarMercenario();
                        case 6 -> filtraMercenariosPorClasse();
                        case 7 -> relatorioMercenariosPorClasse();
                        case 8 -> System.out.println("Encerrando...");
                        default -> System.out.println("Opção inválida, digite novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número.");
                    menu.nextLine();
                }
            } while (opcao != 8);

            menu.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void cadastroMercenario() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do Mercenário:");
            String nome = sc.nextLine();
            System.out.println("Digite a idade do Mercenário:");
            int idade = sc.nextInt();
            System.out.println("Digite a classe do Mercenário (CAVALEIRO, ARQUEIRO, MAGO, ASSASSINO):");
            ClassesV2 classe = ClassesV2.valueOf(sc.next().toUpperCase());
            System.out.println("Digite o salário base do Mercenário:");
            double salarioBase = sc.nextDouble();
            System.out.println("Digite o tempo de serviço do Mercenário (Em Horas):");
            int tempoServico = sc.nextInt();
            System.out.println("Digite o desempenho do Mercenário (Entre 1 e 5):");
            int desempenho = sc.nextInt();
            if (desempenho < 1 || desempenho > 5) {
                System.out.println("Desempenho inválido! Tente novamente.");
            } else{
                switch (classe){
                    case ARQUEIRO:
                        System.out.println("Escolha uma habilidade especial do Arqueiro:");
                        for (HabilidadesArqueiro habilidade : HabilidadesArqueiro.values()) {
                            System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                        }
                        int escolhaArqueiro = sc.nextInt();
                        HabilidadesArqueiro habilidadeArqueiro = HabilidadesArqueiro.values()[escolhaArqueiro];
                        if(habilidadeArqueiro instanceof HabilidadesArqueiro){
                            Mercenario mercenario = new Arqueiro(nome, idade, salarioBase, tempoServico, desempenho, habilidadeArqueiro);
                            mercenarios.add(mercenario);
                        } else {
                            System.out.println("Habilidade Inválida!");
                            break;
                        }
                    case ASSASSINO:
                        System.out.println("Escolha uma habilidade especial do Assassino:");
                        for (HabilidadesAssassino habilidade : HabilidadesAssassino.values()) {
                            System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                        }
                        int escolha = sc.nextInt();
                        HabilidadesAssassino habilidadeAssassino = HabilidadesAssassino.values()[escolha];
                        if(habilidadeAssassino instanceof HabilidadesAssassino){
                            Mercenario mercenario = new Assassino(nome, idade, salarioBase, tempoServico, desempenho, habilidadeAssassino);
                            mercenarios.add(mercenario);
                        } else {
                            System.out.println("Habilidade Inválida!");
                            break;
                        }
                    case CAVALEIRO:
                        System.out.println("Escolha uma habilidade especial do Cavaleiro:");
                        for (HabilidadesCavaleiro habilidade : HabilidadesCavaleiro.values()) {
                            System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                        }
                        int escolhaCavaleiro = sc.nextInt();
                        HabilidadesCavaleiro habilidadeCavaleiro = HabilidadesCavaleiro.values()[escolhaCavaleiro];
                        if(habilidadeCavaleiro instanceof HabilidadesCavaleiro){
                            Mercenario mercenario = new Cavaleiro(nome, idade, salarioBase, tempoServico, desempenho, habilidadeCavaleiro);
                            mercenarios.add(mercenario);
                        } else {
                            System.out.println("Habilidade Inválida!");
                            break;
                        }
                    case MAGO:
                        System.out.println("Escolha uma habilidade especial do Mago:");
                        for (HabilidadesMago habilidade : HabilidadesMago.values()) {
                            System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                        }
                        int escolhaMago = sc.nextInt();
                        HabilidadesMago habilidadeMago = HabilidadesMago.values()[escolhaMago];
                        if(habilidadeMago instanceof HabilidadesMago){
                            Mercenario mercenario = new Mago(nome, idade, salarioBase, tempoServico, desempenho, habilidadeMago);
                            mercenarios.add(mercenario);
                        } else {
                            System.out.println("Habilidade Inválida!");
                            break;
                        }
            }
                System.out.println("Mercenário cadastrado com sucesso!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada! Verifique os valores inseridos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Classe inválida! Digite uma classe válida.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao cadastrar o mercenário. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listarMercenarios() {
        try {
            if (mercenarios.isEmpty()) {
                System.out.println("Sem mercenários cadastrados!");
            } else {
                for (Mercenario mercenario : mercenarios) {
                    System.out.println(mercenario);
                    System.out.println(mercenario.exibeHabilidade());
                    System.out.printf("Salário Final: %.2f\n", mercenario.calcularSalarioFinal());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao listar os mercenários. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void buscarMercenario() {
        try {
            if (mercenarios.isEmpty()) {
                System.out.println("Sem mercenários cadastrados!");
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite o nome do Mercenário que deseja buscar:");
                String nome = sc.nextLine();
                boolean encontrado = false;

                for (Mercenario mercenario : mercenarios) {
                    if (nome.equalsIgnoreCase(mercenario.getNome())) {
                        System.out.println(mercenario);
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Não foi encontrado nenhum mercenário com esse nome!");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao buscar o mercenário. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void filtraMercenariosPorClasse() {
        try {
            if (mercenarios.isEmpty()) {
                System.out.println("Sem mercenários cadastrados!");
                return;
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite a classe que deseja filtrar:");
                ClassesV2 classeEscolhida = ClassesV2.valueOf(sc.next().toUpperCase());

                boolean encontrado = false;
                for (Mercenario mercenario : mercenarios) {
                    if (verificaClasse(mercenario, classeEscolhida)) {
                        System.out.println(mercenario);
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Nenhum mercenário encontrado para a classe especificada.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Classe inválida! Digite uma classe válida.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao filtrar os mercenários. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void relatorioMercenariosPorClasse() {
        try {
            if (mercenarios.isEmpty()) {
                System.out.println("Sem mercenários cadastrados!");
                return;
            }

            Map<String, Integer> contagemClasses = new HashMap<>();

            for (Mercenario mercenario : mercenarios) {
                String classe;
                if (mercenario instanceof Arqueiro) {
                    classe = "Arqueiro";
                } else if (mercenario instanceof Assassino) {
                    classe = "Assassino";
                } else if (mercenario instanceof Cavaleiro) {
                    classe = "Cavaleiro";
                } else if (mercenario instanceof Mago) {
                    classe = "Mago";
                } else {
                    classe = "Desconhecido";
                }
                contagemClasses.put(classe, contagemClasses.getOrDefault(classe, 0) + 1);
            }

            System.out.println("==== Relatório de Distribuição de Classes ====");
            for (String classe : contagemClasses.keySet()) {
                System.out.printf("%s: %d\n", classe, contagemClasses.get(classe));
            }
            System.out.println("===========================================");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao gerar o relatório. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void atualizarMercenario() {
        try {
            if (mercenarios.isEmpty()) {
                System.out.println("Sem mercenários cadastrados!");
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite o ID do mercenário que deseja atualizar:");
                int id = sc.nextInt();
                sc.nextLine();

                if (id >= 0 && id < mercenarios.size()) {
                    System.out.println("Digite o novo nome do Mercenário:");
                    String nome = sc.nextLine();
                    System.out.println("Digite a nova idade do Mercenário:");
                    int idade = sc.nextInt();
                    System.out.println("Digite a nova classe do Mercenário (CAVALEIRO, ARQUEIRO, MAGO, ASSASSINO):");
                    ClassesV2 classe = ClassesV2.valueOf(sc.next().toUpperCase());
                    System.out.println("Digite o novo salário base do Mercenário:");
                    double salarioBase = sc.nextDouble();
                    System.out.println("Digite o novo tempo de serviço do Mercenário (Em Horas):");
                    int tempoServico = sc.nextInt();
                    System.out.println("Digite o novo desempenho do Mercenário (Entre 1 e 5):");
                    int desempenho = sc.nextInt();
                    if (desempenho < 1 || desempenho > 5) {
                        System.out.println("Desempenho inválido! Tente novamente.");
                    } else {
                        switch (classe){
                            case ARQUEIRO:
                                System.out.println("Escolha uma habilidade especial do Arqueiro:");
                                for (HabilidadesArqueiro habilidade : HabilidadesArqueiro.values()) {
                                    System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                                }
                                int escolhaArqueiro = sc.nextInt();
                                HabilidadesArqueiro habilidadeArqueiro = HabilidadesArqueiro.values()[escolhaArqueiro];
                                if(habilidadeArqueiro instanceof HabilidadesArqueiro){
                                    Mercenario mercenarioAtt = new Arqueiro(nome, idade, salarioBase, tempoServico, desempenho, habilidadeArqueiro);
                                    mercenarios.set(id, mercenarioAtt);
                                } else {
                                    System.out.println("Habilidade Inválida!");
                                    break;
                                }
                            case ASSASSINO:
                                System.out.println("Escolha uma habilidade especial do Assassino:");
                                for (HabilidadesAssassino habilidade : HabilidadesAssassino.values()) {
                                    System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                                }
                                int escolha = sc.nextInt();
                                HabilidadesAssassino habilidadeAssassino = HabilidadesAssassino.values()[escolha];
                                if(habilidadeAssassino instanceof HabilidadesAssassino){
                                    Mercenario mercenarioAtt = new Assassino(nome, idade, salarioBase, tempoServico, desempenho, habilidadeAssassino);
                                    mercenarios.set(id, mercenarioAtt);
                                } else {
                                    System.out.println("Habilidade Inválida!");
                                    break;
                                }
                            case CAVALEIRO:
                                System.out.println("Escolha uma habilidade especial do Cavaleiro:");
                                for (HabilidadesCavaleiro habilidade : HabilidadesCavaleiro.values()) {
                                    System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                                }
                                int escolhaCavaleiro = sc.nextInt();
                                HabilidadesCavaleiro habilidadeCavaleiro = HabilidadesCavaleiro.values()[escolhaCavaleiro];
                                if(habilidadeCavaleiro instanceof HabilidadesCavaleiro){
                                    Mercenario mercenarioAtt = new Cavaleiro(nome, idade, salarioBase, tempoServico, desempenho, habilidadeCavaleiro);
                                    mercenarios.set(id, mercenarioAtt);
                                } else {
                                    System.out.println("Habilidade Inválida!");
                                    break;
                                }
                            case MAGO:
                                System.out.println("Escolha uma habilidade especial do Mago:");
                                for (HabilidadesMago habilidade : HabilidadesMago.values()) {
                                    System.out.println(habilidade.ordinal() + " - " + habilidade.getDescricao());
                                }
                                int escolhaMago = sc.nextInt();
                                HabilidadesMago habilidadeMago = HabilidadesMago.values()[escolhaMago];
                                if(habilidadeMago instanceof HabilidadesMago){
                                    Mercenario mercenarioAtt = new Mago(nome, idade, salarioBase, tempoServico, desempenho, habilidadeMago);
                                    mercenarios.set(id, mercenarioAtt);
                                } else {
                                    System.out.println("Habilidade Inválida!");
                                    break;
                                }
                        }
                        System.out.println("Mercenário atualizado com sucesso!");
                    }
                } else {
                    System.out.println("ID não encontrado!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada! Verifique os valores inseridos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Classe inválida! Digite uma classe válida.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao atualizar o mercenário. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removerMercenario() {
        try {
            if (mercenarios.isEmpty()) {
                System.out.println("Sem mercenários cadastrados!");
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite o ID do mercenário que deseja remover:");
                int id = sc.nextInt();

                if (id >= 0 && id < mercenarios.size()) {
                    mercenarios.remove(id);
                    System.out.println("Mercenário removido com sucesso!");
                } else {
                    System.out.println("ID não encontrado!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada! Verifique os valores inseridos.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao remover o mercenário. Detalhes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean verificaClasse(Mercenario mercenario, ClassesV2 classeEscolhida) {
        if (classeEscolhida == ClassesV2.ARQUEIRO && mercenario instanceof Arqueiro) {
            return true;
        } else if (classeEscolhida == ClassesV2.ASSASSINO && mercenario instanceof Assassino) {
            return true;
        } else if (classeEscolhida == ClassesV2.CAVALEIRO && mercenario instanceof Cavaleiro) {
            return true;
        } else if (classeEscolhida == ClassesV2.MAGO && mercenario instanceof Mago) {
            return true;
        }
        return false;
    }
}

