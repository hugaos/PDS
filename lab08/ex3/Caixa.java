package lab08.ex3;

import java.util.ArrayList;

public class Caixa extends Produto {
    private Double weight = 0.0;
    private ArrayList<Produto> products = new ArrayList<Produto>();

    public Caixa(String name, double peso) {
        super(name, peso);
    }

    public void add(Produto product) {
        products.add(product);
        this.weight += product.getWeight();
    }

    @Override
    public void draw() {
        System.out.println(this.getName() + " (" + this.getWeight() + "Kg) ");
        for (Produto product : products) {
            product.draw();
        }
    }
}
