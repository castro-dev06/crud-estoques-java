package service;

import entities.Estoque;

import java.util.List;
import java.util.Scanner;

public class EstoqueService {
    public static void cadastrarProduto(List<Estoque> list, Scanner sc){
        System.out.println("----- CADASTRAR PRODUTO -----");
        System.out.print("ID: ");
        int id = sc.nextInt();

        while (temId(list, id)){
            System.out.print("Erro! Esse ID já existe. Tente novamente: ");
            id = sc.nextInt();
        }

        System.out.print("Nome: ");
        sc.nextLine();
        String nome = sc.nextLine();

        while (nome.trim().isEmpty()){
            System.out.println("Erro! Nome Inválido");
            System.out.print("Tente Novamente: ");
            nome = sc.nextLine();
        }

        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        while (preco <= 0){
            System.out.print("Preço Inválido! Tente novamente: ");
            preco = sc.nextDouble();
        }

        System.out.print("Há uma quantidade inicial no estoque? (S/N) ");
        char respQuantidade = ' ';

        while (respQuantidade != 's' && respQuantidade != 'n'){
            respQuantidade = Character.toLowerCase(sc.next().charAt(0));

            if (respQuantidade != 's' && respQuantidade != 'n'){
                System.out.println("Erro! Insira 'S' para sim ou 'N' para não! ");
                System.out.print("Tente Novamente: ");
            }
        }

        if (respQuantidade == 's'){
            System.out.print("Insira a quantidade: ");
            int quantidade = sc.nextInt();

            while (quantidade <= 0){
                System.out.println("Erro! Quantidade Inválida.");
                System.out.print("Tente Novamente: ");
                quantidade = sc.nextInt();
            }

            Estoque estoque = new Estoque(id, nome, preco, quantidade);

            list.add(estoque);
        } else {

            Estoque estoque = new Estoque(id, nome, preco);

            list.add(estoque);
        }

        System.out.println();
        System.out.println("* PRODUTO CADASTRADO COM SUCESSO *");
    }

    public static void atualizarProduto(List<Estoque> list, Scanner sc){
        System.out.println("----- ATUALIZAR PRODUTO -----");
        System.out.print("Informe o ID do produto que será atualizado: ");
        int id = sc.nextInt();

        Estoque estoqueAtualizarProduto = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        System.out.println();

        if (estoqueAtualizarProduto != null){
            System.out.println(estoqueAtualizarProduto);
            System.out.println();

            System.out.print("Deseja atualizar o nome desse produto? (S/N) ");
            char respAtualizarNome = ' ';

            while (respAtualizarNome != 's' && respAtualizarNome != 'n'){
                respAtualizarNome = Character.toLowerCase(sc.next().charAt(0));

                if (respAtualizarNome != 's' && respAtualizarNome != 'n'){
                    System.out.println("Erro! Insira 'S' para sim ou 'N' para não! ");
                    System.out.print("Tente Novamente: ");
                }
            }

            if (respAtualizarNome == 's'){
                System.out.print("Informe o novo nome: ");
                sc.nextLine();
                String nomeAtualizar = sc.nextLine();

                while (nomeAtualizar.trim().isEmpty()){
                    System.out.println("Erro! Nome Inválido");
                    System.out.print("Tente Novamente: ");
                    nomeAtualizar = sc.nextLine();
                }

                estoqueAtualizarProduto.setNome(nomeAtualizar);

                System.out.println();
                System.out.println("* NOME ATUALIZADO COM SUCESSO *");
            }
            System.out.println();
            System.out.print("Deseja atualizar o preço desse produto? (S/N) ");
            char respAtualizaPreco = ' ';

            while (respAtualizaPreco != 's' && respAtualizaPreco != 'n'){
                respAtualizaPreco = Character.toLowerCase(sc.next().charAt(0));

                if (respAtualizaPreco != 's' && respAtualizaPreco != 'n'){
                    System.out.println("Erro! Insira 'S' para sim ou 'N' para não! ");
                    System.out.print("Tente Novamente: ");
                }
            }

            if (respAtualizaPreco == 's'){
                System.out.print("Informe o novo preço: ");
                double precoAtualizar = sc.nextDouble();

                while (precoAtualizar <= 0){
                    System.out.println("Erro! Preço Inválido.");
                    System.out.print("Tente Novamente: ");
                    precoAtualizar = sc.nextDouble();
                }

                estoqueAtualizarProduto.setPreco(precoAtualizar);

                System.out.println();
                System.out.println("* PREÇO ATUALIZADO *");
            }

        } else {
            System.out.println("Erro! Esse ID não existe! ");
        }
    }
    public static void removerProduto(List<Estoque> list, Scanner sc) {
        System.out.println("----- REMOVER PRODUTO -----");
        System.out.print("Informe o ID do produto que irá remover: ");
        int id = sc.nextInt();

        Estoque estoqueRemoverProduto = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        System.out.println();

        if (estoqueRemoverProduto != null && estoqueRemoverProduto.getQuantidade() > 0){
            System.out.println(estoqueRemoverProduto);
            System.out.println();

            System.out.println("Erro! O produto só será removido se a quantidade no estoque for igual a 0.");
        } else {
            if (estoqueRemoverProduto != null) {
                System.out.println(estoqueRemoverProduto);
                System.out.println();

                System.out.print("Deseja remover esse produto? (S/N) ");
                char respRemoverProduto = ' ';

                while (respRemoverProduto != 's' && respRemoverProduto != 'n') {
                    respRemoverProduto = Character.toLowerCase(sc.next().charAt(0));

                    if (respRemoverProduto != 's' && respRemoverProduto != 'n') {
                        System.out.println("Erro! Insira 'S' para sim ou 'N' para não! ");
                        System.out.print("Tente Novamente: ");
                    }
                }

                if (respRemoverProduto == 's') {
                    list.remove(estoqueRemoverProduto);

                    System.out.println();
                    System.out.println("* PRODUTO REMOVIDO COM SUCESSO *");
                } else {
                    System.out.println();
                    System.out.println("* PRODUTO NÃO REMOVIDO *");
                }

            } else {
                System.out.println("Erro! Esse ID não existe.");
            }
        }
    }

    public static void listarProdutos (List < Estoque > list){
        System.out.println("----- LISTA DE PRODUTO -----");

        System.out.println();
        if (list.isEmpty()) {
            System.out.println("Lista vazia! Adicione um produto na sessão de cadastro!");
            System.out.println();
        } else {
            int i = 1;
            for (Estoque listarProduto : list) {
                System.out.println("Produto#" + i);
                System.out.println(listarProduto);
                System.out.println();
                i++;
            }
        }
    }


    public static void operacoesProduto(List<Estoque> list, Scanner sc){
        System.out.println("----- VENDER / REABASTECER -----");
        System.out.print("Informe o ID do produto: ");
        int idOperacoes = sc.nextInt();

        Estoque estoqueOperacoes = list.stream().filter(x -> x.getId() == idOperacoes).findFirst().orElse(null);

        System.out.println();

        if (estoqueOperacoes != null){
            System.out.println(estoqueOperacoes);
            System.out.println();

            System.out.println("1 - Vender");
            System.out.println("2 - Reabastecer");
            System.out.print("> ");
            int opcao = sc.nextInt();

            System.out.println();
            if (opcao == 1){
                System.out.print("Informe a quantidade do produto que será vendida: ");
                int quantidadeVenda = sc.nextInt();

                System.out.println();
                estoqueOperacoes.vender(quantidadeVenda);


            } else if (opcao == 2){
                System.out.print("Informe a quantidade do produto que será reabastecida: ");
                int quantidadeReabastecimento = sc.nextInt();

                System.out.println();
                estoqueOperacoes.reabastecer(quantidadeReabastecimento);

            } else {
                System.out.println("Erro! Opção Inválida.");
            }

        } else {
            System.out.println("Erro! Esse ID não existe.");
        }
    }
    public static Boolean temId(List<Estoque> list, int id){
        Estoque estoque = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return estoque != null;
    }
}
