package lab10.ex2;

public class DessertChef extends Chefe {

    private String especialidade = "sobremesa";

    public DessertChef(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public Handler pickNextChef(Handler handler) {
        return handler;
    }

    @Override
    public boolean handleRequest(String request) {
        if (request.toLowerCase().contains(especialidade)) {
            System.out.println("Chefe de sobremesa: " + request);
            this.cook(request);
            return true;
        } else {
            System.out.println("Chefe de sobremesa: Não posso fazer isso.");
            return false;
        }
    }

    protected void cook(String request) {
        System.out.println("Chefe de sobremesa: Estou cozinhando " + request + " por " + cookingTime() + " minutos.");
    }

    protected int cookingTime() {
        return (int) (Math.random() * 10 + 10);
    }
}
