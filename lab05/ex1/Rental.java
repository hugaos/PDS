package lab05.ex1;

import java.util.ArrayList;

public class Rental {
    private String nome;
    private String id;
    private String link;
    private ArrayList<Veiculo> stock;

    public Rental(String nome, String id, String link) {
        this.nome = nome;
        this.id = id;
        this.link = link;
        this.stock = new ArrayList<Veiculo>();
    }

    public void addVeiculo(Veiculo v) {
        this.stock.add(v);
    }

    public ArrayList<Veiculo> getStock() {
        return this.stock;
    }
}
