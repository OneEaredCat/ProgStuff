/**
* Dies ist die erste Programmieren 2 Hausaufgabe
* von
* @author Simon Schmidt 4701325 Gruppe 10A
*/

class ListEntry<T extends Comparable<T>> {
    ListEntry<T> prev = null; //ListEntry is a raw type. References to generic type ListEntry<T> should be parameterized
    ListEntry<T> next = null;
    private T data;

    ListEntry(T data) { //Comparable durch T ersetzt, da data nicht mehr vom Typ comparable, sondern vom eingeführten Typ T sein muss.
        this.data = data;
    }

    public T value() {
        return data;
    }

    public int compareTo(T o) {
        if (o instanceof ListEntry) {
            ListEntry<T> e = (ListEntry<T>) o;
            return data.compareTo(e.value());
        } else {
            return data.compareTo(o);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof ListEntry) {
            ListEntry<T> e = (ListEntry<T>) o;
            return data.equals(e.value());
        } else {
            return false;
        }
    }

    public String toString() {
        return data.toString();
    }
}
