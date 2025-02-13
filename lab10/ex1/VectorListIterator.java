import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorListIterator<T> implements ListIterator<T> {
    private int currentIndex;
    private final VectorGeneric<T> vector;

    public VectorListIterator(VectorGeneric<T> vector, int index) {
        this.currentIndex = index;
        this.vector = vector;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < vector.totalElem();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Operation denied!");
        }
        return vector.getElem(currentIndex++);
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex > 0;
    }

    @Override
    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("Operation denied!");
        }
        return vector.getElem(--currentIndex);
    }

    @Override
    public int nextIndex() {
        return currentIndex;
    }

    @Override
    public int previousIndex() {
        return currentIndex - 1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Não implementada");
    }

    @Override
    public void set(T e) {
        throw new UnsupportedOperationException("Não implementada");
    }

    @Override
    public void add(T e) {
        throw new UnsupportedOperationException("Não implementada");
    }
}
