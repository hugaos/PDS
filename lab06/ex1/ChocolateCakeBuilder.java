package ex1;

public class ChocolateCakeBuilder implements CakeBuilder {

    Cake cake;

    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Soft chocolate");
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
        cake.setMidLayerCream(null);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        cake.setTopping(Topping.Fruit);
    }

    public void addMessage(String message) {
        cake.setMessage(message);
    }

}
