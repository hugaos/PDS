package ex1;

public class CakeMaster {

    private CakeBuilder builder;

    public void setCakeBuilder(CakeBuilder builder) {
        this.builder = builder;
    }

    // Create a cake with a specific shape, number of layers and message
    public void createCake(Shape shape, int numLayers, String message) {
        builder.createCake();
        builder.setCakeShape(shape);

        for (int i = 0; i < numLayers; i++)
            builder.addCakeLayer();

        builder.addCreamLayer();
        builder.addTopLayer();
        builder.addTopping();
        builder.addMessage(message);
    }

    // Create a cake with a specific number of layers and message
    public void createCake(int numLayers, String message) {
        builder.createCake();

        for (int i = 0; i < numLayers; i++)
            builder.addCakeLayer();

        builder.addCreamLayer();
        builder.addTopLayer();
        builder.addTopping();
        builder.addMessage(message);
    }

    // Create a cake with a message
    public void createCake(String message) {
        builder.createCake();
        builder.addCakeLayer();
        builder.addCreamLayer();
        builder.addTopLayer();
        builder.addTopping();
        builder.addMessage(message);
    }

    public Cake getCake() {
        return builder.getCake();
    }
}
