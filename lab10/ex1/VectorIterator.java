import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorIterator<T> implements Iterator<T> {
    private VectorGeneric<T> vector;
    private int index;

    public VectorIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < vector.totalElem();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Operation denied!");
        }
        return vector.getElem(index++);
    }
}
