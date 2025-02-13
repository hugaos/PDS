package ex1;

public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake() {
        shape = Shape.ROUND;
        numCakeLayers = 0;
    }

    // Getters

    public Shape getShape() {
        return shape;
    }

    public String getCakeLayer() {
        return cakeLayer;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public Cream getMidLayerCream() {
        return midLayerCream;
    }

    public Cream getTopLayerCream() {
        return topLayerCream;
    }

    public Topping getTopping() {
        return topping;
    }

    public String getMessage() {
        return message;
    }

    // Setters

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // ToString

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s cake with %d layers", cakeLayer, numCakeLayers));

        if (midLayerCream != null && numCakeLayers > 1)
            output.append(String.format(" and %s cream", midLayerCream));

        output.append(
                String.format(", topped with %s cream, and %s. Message says: '%s'.", topLayerCream, topping, message));

        return output.toString();
    }

}
