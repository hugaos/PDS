package lab05.ex2;

public class PlasticBottle extends Container {
    protected PlasticBottle(Portion portion) {
        super(portion);
    }

    public String toString() {
        return "PlasticBottle with portion=" + getPortion().toString();
    }
}
