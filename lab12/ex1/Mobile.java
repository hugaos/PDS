public class Mobile {
    private final String brand;
    private String processor;
    private int price;
    private String camera;
    
    public Mobile(String brand, String processor, int price, String camera) {
        this.brand = brand;
        this.processor = processor;
        this.price = price;
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Mobile [brand=" + brand + ", camera=" + camera + ", price=" + price + ", processor=" + processor + "]";
    }

}
