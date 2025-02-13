package ex1;

public class YogurtCakeBuilder implements CakeBuilder {

    Cake cake;

    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Soft yogurt");
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
        cake.setMidLayerCream(Cream.Vanilla);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
    }

    public void addMessage(String message) {
        cake.setMessage(message);
    }

}