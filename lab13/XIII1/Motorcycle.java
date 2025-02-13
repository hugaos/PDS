public class Motorcycle implements Product {
    private String code;
    private String description;
    private double points;

    public Motorcycle(String code, String desc, double points){
        this.code=code;
        this.description=desc;
        this.points=points;
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
}
