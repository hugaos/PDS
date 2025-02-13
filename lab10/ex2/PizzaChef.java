package lab10.ex2;

public class PizzaChef extends Chefe {

    private String especialidade = "pizza";

    public PizzaChef(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public Handler pickNextChef(Handler handler) {
        return handler;
    }

    @Override
    public boolean handleRequest(String request) {
        if (request.toLowerCase().contains(especialidade)) {
            System.out.println("Chefe de pizza: " + request);
            this.cook(request);
            return true;
        } else {
            System.out.println("Chefe de pizza: Não posso fazer isso.");
            return false;
        }
    }

    protected void cook(String request) {
        System.out.println("Chefe de pizza: Estou cozinhando " + request + " por " + cookingTime() + " minutos.");
    }

    protected int cookingTime() {
        return (int) (Math.random() * 10 + 10);
    }
}
