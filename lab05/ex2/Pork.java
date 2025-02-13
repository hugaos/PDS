package lab05.ex2;

public class Pork implements Portion{
    private Temperature temperature;
    private State state;

    public Pork(Temperature temperature, State state) {
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
        return "Pork : Temperature " + temperature + ", State " + state;
    }
}
