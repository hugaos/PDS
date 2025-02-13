package lab05.ex2;

public class Milk implements Portion {
    private Temperature temperature;
    private State state;

    public Milk(Temperature temperature, State state) {
        this.temperature = temperature;
        this.state = state;
    }
    
    public Temperature getTemperature() {
        return temperature;
    }

    public State getState() {
        return state;
    }
    @Override
    public String toString() {
        return "Milk : Temperature " + temperature + ", State " + state;
    }
}