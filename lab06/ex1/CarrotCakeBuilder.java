package ex1;

public class CarrotCakeBuilder {

    Cake cake;

    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Soft carrot");
    }

    public Cake getCake() {
        return cake;
    }

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addCakeLayer() {
        cake.setNumCakeLayers(cake.getNumCakeLayers() + 1);
    }

    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Carrot);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        cake.setTopping(Topping.Nuts);
    }

    public void addMessage(String message) {
        cake.setMessage(message);
    }
}
