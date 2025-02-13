package lab10.ex2;

public class Chefe implements Handler {

    protected Handler successor;

    @Override
    public Handler pickNextChef(Handler handler) {
        this.successor = successor;
        return successor;
    }

    @Override
    public boolean handleRequest(String request) {
        if (request != null) {
            System.out.println("Chefe: " + request);
            return true;
        } else {
            System.out.println("Chefe: Não posso fazer isso.");
            return false;
        }
    }

    protected void cook(String request) {
        System.out.println("Chefe: Estou cozinhando " + request + " por " + cookingTime() + " minutos.");
    }

    protected int cookingTime() {
        return (int) (Math.random() * 10 + 10);
    }

}