package lab05.ex2;


public abstract class PortionFactory implements Portion {
    private Temperature temperature;
    private State state;
    public Temperature getTemperature() {
        return temperature;
    }
    public State getState() {
        return state;
    }
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
    public void setState(State state) {
        this.state = state;
    }
    public static Portion create(String type, Temperature temperature) {
        if (type.equals("Beverage")) {
            if (temperature==Temperature.COLD) {
                return new FruitJuice(temperature, State.Liquid);
            } else if (temperature.equals(Temperature.WARM)) {
                return new Milk(temperature, State.Liquid);
            }
        } else if (type.equals("Meat")) {
            if (temperature.equals(Temperature.COLD)) {
                return new Tuna(temperature, State.Solid);
            } else if (temperature.equals(Temperature.WARM)) {
                return new Pork(temperature, State.Solid);
            }   
        }
        return null;
    }
}
