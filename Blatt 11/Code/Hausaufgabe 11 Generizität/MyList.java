import de.tu_bs.ips.List;
/**
* Dies ist die erste Programmieren 2 Hausaufgabe
* von
* @author Simon Schmidt 4701325 Gruppe 10A
*/

class MyList<T extends Comparable<T>> implements List<T> {   //<T extends Comparable<T>> geht sicher, dass der Typ T auch vergleichbar und sortierbar ist. T kann somit z.b. keine farbe sein.
    private ListEntry<T> head = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T first() {
        return head.value(); // da T erwartet wird
    }
    /**
    * @return gibt den ersten Eintrag der Liste zur�ck, head
    */
    public ListEntry<T> firstEntry() {
        return head;
    }

    @Override
    public void insert(T e) {
        ListEntry<T> newEntry = new ListEntry<T>(e); // Eintrag erzeugen

        if (head == null) {
            head = newEntry; // Einfuegen, falls Liste leer ist
            head.prev = head;
            head.next = head;
            return;
        }

        head.prev.next = newEntry;
        newEntry.prev = head.prev;
        head.prev = newEntry; // Erstes Element zeigt auf neues Element
        newEntry.next = head; // Neues Element zeigt auf voriges erstes Element
        head = newEntry;
    }

    @Override
    public void append(T e) {
        ListEntry<T> newEntry = new ListEntry<T>(e); // Eintrag erzeugen

        if (head == null) {
            head = newEntry; // Einfuegen, falls Liste leer ist
            head.prev = head;
            head.next = head;
            return;
        }

        newEntry.next = head;
        head.prev.next = newEntry; // Letztes Element zeigt auf neues Element
        newEntry.prev = head.prev; // Neues Element zeigt auf voriges letztes Element
        head.prev = newEntry;
    }

    @Override
    public void delete(T e) {
        // Startelemente auf null setzen falls letztes Element entfernt wird
        if (e.equals(head) && head.next == head) {
            head = null;
            return;
        }

        ListEntry<T> current = head;
        do {
            if (current.compareTo(e) == 0) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }
        } while (current.next != head);
    }

    @Override
    public int length() {
        if (head == null) {
            return 0;
        }

        int counter = 0;
        ListEntry<T> current = head;
        do {
            counter++;
            current = current.next;
        } while (current != head);
        return counter;
    }
    /**
    * Erstellt iterator und @return gibt den erstellten iterator zur�ck
    */
    public DLLIterator iterator() {
        return new DLLIterator(this);
    }
}
