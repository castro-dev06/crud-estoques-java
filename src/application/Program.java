package application;

import entities.Estoque;
import service.EstoqueService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Estoque> list = new ArrayList<>();

        int opcaoProdutos;

        System.out.println();
        System.out.println("===== CONTROLE DE ESTOQUE =====");

            do {

                System.out.println("-----------------------------");
                System.out.println();
                System.out.println("MENU INTELIGENTE");
                System.out.println("1 - Cadastrar Produto");
                System.out.println("2 - Atualizar Produto");
                System.out.println("3 - Remover Produto");
                System.out.println("4 - Listar Produtos");
                System.out.println("5 - Vender/Reabastecer");
                System.out.println("6 - Sair");

                System.out.println();
                System.out.print("Escolha a sua opção: ");
                opcaoProdutos = sc.nextInt();

                System.out.println();

                switch (opcaoProdutos) {
                    case 1:
                        EstoqueService.cadastrarProduto(list, sc);
                        break;
                    case 2:
                        EstoqueService.atualizarProduto(list, sc);
                        break;
                    case 3:
                        EstoqueService.removerProduto(list, sc);
                        break;
                    case 4:
                        EstoqueService.listarProdutos(list);
                        break;
                    case 5:
                        EstoqueService.operacoesProduto(list, sc);
                        break;
                    case 6:
                        System.out.println("Saindo Do Sistema....");
                        break;
                    default:
                        System.out.println("🚫Erro! Opção Inválida 🚫");
                }

            } while (opcaoProdutos != 6);
        sc.close();
    }

}
