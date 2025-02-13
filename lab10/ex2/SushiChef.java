package lab10.ex2;

public class SushiChef extends Chefe {

    private String especialidade = "sushi";

    public SushiChef(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public Handler pickNextChef(Handler handler) {
        return handler;
    }

    @Override
    public boolean handleRequest(String request) {
        if (request.toLowerCase().contains(especialidade)) {
            System.out.println("Chefe de sushi: " + request);
            this.cook(request);
            return true;
        } else {
            System.out.println("Chefe de sushi: Não posso fazer isso.");
            return false;
        }
    }

    protected void cook(String request) {
        System.out.println("Chefe de sushi: Estou cozinhando " + request + " por " + cookingTime() + " minutos.");
    }

    protected int cookingTime() {
        return (int) (Math.random() * 10 + 10);
    }
}
