import de.tu_bs.ips.List;
import de.tu_bs.ips.DataSource;
import java.util.Iterator;
/**
* Dies ist die erste Programmieren 2 Hausaufgabe
* von
* @author Simon Schmidt 4701325 Gruppe 10A
*/
class TestSuite {
    public static void main(String[] args) {
        List list = new MyList();
        DataSource source = new DataSource(DataSource.Mode.A);

        Integer[] input = source.next();
        for (int i = 0; i < input.length; i++) {
            list.sortedInsert(input[i]);
        }

        input = source.next();
        for (int i = 0; i < input.length; i++) {
            list.insert(input[i]);
        }

        input = source.next();
        for (int i = 0; i < input.length; i++) {
            list.append(input[i]);
        }

        System.out.println(list.length());

        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println(list.isEmpty());
    }
}
