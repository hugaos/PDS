import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<>();
        Iterator<String> iterator;
        ListIterator<String> listIterator;

        vector.addElem("H");
        vector.addElem("u");
        vector.addElem("g");
        vector.addElem("o");

        System.out.println("Iterator:");
        iterator = vector.Iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();

        System.out.println("ListIterator");
        listIterator = vector.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
        }
        System.out.println();

        System.out.println("ListIterator (index 2):");
        listIterator = vector.listIterator(2);
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
        }
        System.out.println();
    }
}
