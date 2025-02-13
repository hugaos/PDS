package lab05.ex2;

public interface Portion {

    public Temperature getTemperature();

    public State getState();

    public enum State {
        Solid, Liquid;
    }

    public enum Temperature {
        WARM, COLD;
    }
}
