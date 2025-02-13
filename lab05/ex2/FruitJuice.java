package lab05.ex2;

public class FruitJuice implements Portion {
    private Temperature temperature;
    private State state;

    public FruitJuice(Temperature temperature, State state) {
        this.temperature = temperature;
        this.state = state;
    }
    
    public Temperature getTemperature(){
        return temperature;
    }

    public State getState(){
        return state;
    }
    @Override
    public String toString() {
        return "FruitJuice : Temperature " + temperature + ", State " + state;
    }
}
