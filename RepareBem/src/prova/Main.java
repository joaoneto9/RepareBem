package prova;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RepareBem sistema = new RepareBem();
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== SISTEMA REPARE BEM =====");
            System.out.println("1. Cadastrar Reparo");
            System.out.println("2. Reajustar Preço de Reparo");
            System.out.println("3. Cadastrar Ordem de Serviço");
            System.out.println("4. Incluir Reparo em Ordem de Serviço");
            System.out.println("5. Mudar Status de Ordem de Serviço");
            System.out.println("6. Exibir Ordem de Serviço");
            System.out.println("7. Obter Valor da Ordem de Serviço");
            System.out.println("8. Listar Ordens de Serviço por Status");
            System.out.println("9. Listar Todas as Ordens de Serviço");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha (liberar o buffer :) )

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("ID do Reparo: ");
                        String id = sc.nextLine();
                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
                        sistema.cadastrarReparo(id, descricao, preco);
                        System.out.println("Reparo cadastrado com sucesso.");
                        break;

                    case 2:
                        System.out.print("ID do Reparo: ");
                        String idReparo = sc.nextLine();
                        System.out.print("Percentual de reajuste (ex: 10.5): ");
                        double percentual = sc.nextDouble();
                        sistema.reajustarPrecoReparo(idReparo, percentual);
                        System.out.println("Preço reajustado com sucesso.");
                        break;

                    case 3:
                        System.out.print("Nome do Cliente: ");
                        String cliente = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("Roupa: ");
                        String roupa = sc.nextLine();
                        int idOS = sistema.cadastrarOrdemDeServico(cliente, telefone, roupa);
                        System.out.println("Ordem de Serviço cadastrada com ID: " + idOS);
                        break;

                    case 4:
                        System.out.print("ID da Ordem de Serviço: ");
                        int idOSReparo = sc.nextInt();
                        sc.nextLine(); // consumir quebra de linha
                        System.out.print("ID do Reparo a incluir: ");
                        String idReparoIncluir = sc.nextLine();
                        sistema.incluirReparoOrdemDeServico(idOSReparo, idReparoIncluir);
                        System.out.println("Reparo incluído na Ordem de Serviço.");
                        break;

                    case 5:
                        System.out.print("ID da Ordem de Serviço: ");
                        int idStatus = sc.nextInt();
                        sc.nextLine(); // consumir quebra de linha
                        System.out.print("Novo status: ");
                        String status = sc.nextLine();
                        sistema.mudarStatusOrdemDeServico(idStatus, status);
                        System.out.println("Status alterado.");
                        break;

                    case 6:
                        System.out.print("ID da Ordem de Serviço: ");	
                        int idExibir = sc.nextInt();
                        System.out.println(sistema.exibirOrdemDeServico(idExibir));
                        break;

                    case 7:
                        System.out.print("ID da Ordem de Serviço: ");
                        int idValor = sc.nextInt();
                        System.out.println("Valor total: R$ " + sistema.obterValorOrdemServico(idValor));
                        break;

                    case 8:
                        System.out.print("Status a filtrar: ");
                        String filtroStatus = sc.nextLine();
                        // corrigir chamada incorreta
                        System.out.println(sistema.listarOrdemDeServico(filtroStatus));
                        break;
                        
                    case 9:
                        System.out.println(sistema.listarOrdemDeServico()); 
                        break;

                    case 10:
                        executando = false;
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}
