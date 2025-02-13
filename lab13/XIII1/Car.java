public class Car implements Product {
    private String code;
    private String description;
    private double points;
    private State state;

    public Car(String code, String desc, double points) {
        this.code = code;
        this.description = desc;
        this.points = points;
        this.state = new SharedState();
    }

    public String code() {
        return this.code;
    }

    public String description() {
        return this.description;
    }

    public double points() {
        return this.points;

    }

    public boolean share(Client c) {
    }

}
