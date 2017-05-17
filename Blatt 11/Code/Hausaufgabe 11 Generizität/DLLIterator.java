import java.util.Iterator;
import java.util.NoSuchElementException;
/**
* Dies ist die erste Programmieren 2 Hausaufgabe
* von
* @author Simon Schmidt 4701325 Gruppe 10A
*/
class DLLIterator implements Iterator {
    MyList list;
    ListEntry current;

    DLLIterator(MyList list) {
        this.list = list;
        current = null;
    }
    
    public boolean hasNext() {
        if (current == null) {
            return !list.isEmpty();
        } else {
            return current.next != list.firstEntry();
        }
    }
    /**
    * Checkt ob es ein next element gibt, wenn nicht wirft es eine NoSuchElementException. Wenn doch, dann @return den wert von der next value.
    */
    public Comparable next() throws NoSuchElementException {
        if (hasNext()) {
            current = current == null ? list.firstEntry() : current.next;
            return current.value();
        } else {
            throw new NoSuchElementException();
        }
    }
}
