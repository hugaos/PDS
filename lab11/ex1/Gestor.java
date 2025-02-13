import java.util.*;
public class Gestor implements Observer{
    private String nome;
    private List<Leilao> leilao;
    
    public Gestor(String nome) {
        this.nome = nome;
        this.leilao= new ArrayList<>();
    }
    public void addLeilao(Leilao p) {
        leilao.add(p);
    }
    public List<Produto> emLeilao(Leilao l){
        return l.getEmLeilao();
    
    }

    public List<Produto> getVendidos(Leilao l){
        return l.getVendidos();
    }
    public List<Produto> getStock(Leilao l){
        return l.getStock();
    }
    public void update(String msg, Produto p) {
        System.out.println("Gestor "+nome+" recebeu: "+msg);
    }
}
