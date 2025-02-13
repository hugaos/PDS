import java.util.ArrayList;
import java.util.List;  

public class Main {
    public static void main(String[] args) {
        Mobile m1 = new Mobile("Samsung", "Exynos 2100", 1000, "108MP");
        Mobile m2 = new Mobile("Apple", "A14 Bionic", 1200, "12MP");
        Mobile m3 = new Mobile("OnePlus", "Snapdragon 888", 800, "48MP");
        Mobile m4 = new Mobile("Xiaomi", "Snapdragon 870", 700, "108MP");
        Mobile m5 = new Mobile("Google", "Snapdragon 765G", 600, "12MP");
        Mobile m6 = new Mobile("Huawei", "Intel 14800", 5, "bueda pixeis");
        
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(m1);
        mobiles.add(m2);
        mobiles.add(m3);
        mobiles.add(m4);
        mobiles.add(m5);
        mobiles.add(m6);
        
        Revista revista = new Revista(mobiles, new HeapSort());
        revista.sort();
        
        revista.setSortingAlg(new BubbleSort());
        revista.sort();

        revista.setSortingAlg(new InsertionSort());
        revista.sort();

        revista.printMobiles();
    }
}
