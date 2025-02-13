import java.util.*;
public class Cliente  implements Observer{
    private String nome;
    private List<Produto> produtos ;

    public Cliente(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }
    public void update(String msg, Produto p) {
        System.out.println("Cliente "+nome+" recebeu: "+msg);
    }
    public void addProduto(Produto p) {
        produtos.add(p);
    }
    public String getNome() {
        return nome;
    }
}
