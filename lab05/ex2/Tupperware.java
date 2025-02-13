package lab05.ex2;

public class Tupperware extends Container{
    public Tupperware(Portion portion) {
        super(portion);
    }
    public String toString() {
        return "Tupperware with portion=" + getPortion().toString();
    }
}
