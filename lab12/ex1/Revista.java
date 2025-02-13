import java.util.List;
public class Revista {
    public List<Mobile> mobiles;
    public SortingAlg sortingAlg;
    public Revista(List<Mobile> mobiles, SortingAlg sortingAlg) {
        this.mobiles = mobiles;
        this.sortingAlg = sortingAlg;
    }
    public void sort() {
        sortingAlg.sort(mobiles);
    }
    public void printMobiles() {
        for (Mobile mobile : mobiles) {
            System.out.println(mobile);
        }
    }
    public void setSortingAlg(SortingAlg sortingAlg) {
        this.sortingAlg = sortingAlg;
    }
}
