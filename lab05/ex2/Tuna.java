package lab05.ex2;

public class Tuna implements Portion{
    private Temperature temperature;
    private State state;

    public Tuna(Temperature temperature, State state) {
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
        return "Tuna : Temperature" + temperature + ", State " + state;
    }
}
