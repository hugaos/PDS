package lab10.ex2;

public class BurgerChef extends Chefe {

    private String especialidade = "hamburguer";

    public BurgerChef(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public Handler pickNextChef(Handler handler) {
        return handler;
    }

    @Override
    public boolean handleRequest(String request) {
        if (request.toLowerCase().contains(especialidade)) {
            System.out.println("Chefe de hambúrguer: " + request);
            this.cook(request);
            return true;
        } else {
            System.out.println("Chefe de hambúrguer: Não posso fazer isso.");
            return false;
        }
    }

    protected void cook(String request) {
        System.out.println("Chefe de hambúrguer: Estou cozinhando " + request + " por " + cookingTime() + " minutos.");
    }

    protected int cookingTime() {
        return (int) (Math.random() * 10 + 10);
    }
}
