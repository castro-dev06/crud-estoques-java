package entities;

public class Estoque {
    private Integer id;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public Estoque(Integer id, String nome, Double preco, Integer quantidade){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Estoque(Integer id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 0;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double valorTotalEstoque(){
        return preco * quantidade;
    }

    public void vender(int quantidadeVenda){
        if (quantidadeVenda <= 0){
            System.out.println("🚫 Erro! Quantidade Inválida 🚫");

        } else if (quantidadeVenda > this.quantidade) {
            System.out.println("🚫 Erro! Quantidade Insuficiente no Estoque 🚫");

        } else {
            quantidade -= quantidadeVenda;
            System.out.println("* VENDA REALIZADA COM SUCESSO *");
        }
    }
    public void reabastecer(int quantidadeReabastecimento){
        if (quantidadeReabastecimento <= 0){
            System.out.println("🚫 Erro! Quantidade Inválida 🚫");
        }else {
            quantidade += quantidadeReabastecimento;
            System.out.println("* REABASTECIMENTO REALIZADO COM SUCESSO *");
        }
    }

    @Override
    public String toString() {
        return id + ", Nome: " + nome +
                ", Preço: R$" + String.format("%.2f", preco) +
                ", Unidades: " + quantidade +
                ", Total no Estoque: R$" + String.format("%.2f", valorTotalEstoque());
    }
}
