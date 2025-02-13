import java.util.*;
import java.time.*;
public class Leilao {
    private List<Produto> produtos;
    private int tempo;
    private List<Observer> observers = new ArrayList<>();
    private boolean bid=false;
    private List<Produto> emLeilao= new ArrayList<>();
    private List<Produto> vendidos= new ArrayList<>();
    public List<Produto> stock= new ArrayList<>();

    public Leilao() {
        this.produtos = new ArrayList<>();
    }

    public void iniciarLeilao(Produto produto, int tempoEmSegundos) {
        produtos.add(produto);
        produto.setEstado(Estado.LEILAO);
        emLeilao.add(produto);

    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void finalizarLeilao(Produto produto) {
        if (bid){
            produto.setEstado(Estado.VENDA);
            System.out.println("Produto vendido: "+produto.getDescricao()+" por "+produto.getPreco());
            emLeilao.remove(produto);
            vendidos.add(produto);
        } else {
            produto.setEstado(Estado.STOCK); 
            emLeilao.remove(produto);
            stock.add(produto);
        }
    }

    public void placeBid(Observer observer, double preco, Produto produto) {
        for (Produto p : emLeilao) {
            if (p.equals(produto)) {
                if (preco > produto.getPreco()) {
                    observers.add(observer);
                    produto.setPreco(preco);
                    notifyObservers(observer, "Licitação aceite", produto);
                    bid=true;
                    addObserver(observer);

                } else {
                    notifyObservers(observer, "Licitação recusada", produto);
                }
            }
        }
    }
    public void notifyObservers(Observer observer, String msg, Produto produto) {
        for (Observer o : observers) {
            o.update(msg, produto);
        }
    }
    public List<Produto> getEmLeilao() {
        return emLeilao;
    }
    public List<Produto> getVendidos() {
        return vendidos;
    }
    public List<Produto> getStock() {
        return stock;
    }

}
