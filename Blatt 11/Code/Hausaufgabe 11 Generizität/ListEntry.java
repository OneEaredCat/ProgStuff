/**
* Dies ist die erste Programmieren 2 Hausaufgabe
* von
* @author Simon Schmidt 4701325 Gruppe 10A
*/

class ListEntry<T extends Comparable<T>> {
    ListEntry prev = null;
    ListEntry next = null;
    private Comparable data;

    ListEntry(Comparable data) {
        this.data = data;
    }

    public Comparable value() {
        return data;
    }

    public int compareTo(T o) {
        if (o instanceof ListEntry) {
            ListEntry e = (ListEntry) o;
            return data.compareTo(e.value());
        } else {
            return data.compareTo(o);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof ListEntry) {
            ListEntry e = (ListEntry) o;
            return data.equals(e.value());
        } else {
            return false;
        }
    }

    public String toString() {
        return data.toString();
    }
}
