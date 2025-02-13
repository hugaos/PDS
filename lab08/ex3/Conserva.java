package lab08.ex3;

public class Conserva extends Produto {

    public Conserva(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public void draw() {
        System.out.println(this.getName() + " (" + this.getWeight() + "Kg) ");
    }
}
