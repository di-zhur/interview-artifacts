import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewExamples {

    public static void main(String[] args) {
        printReverseListExample2();
    }

    private static void printReverseListExample1() {
        var list = List.of(1, 2, 3, 4, 5, 6);
        var listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    private static void printReverseListExample2() {
        var list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Collections.reverse(list);
        for (var item : list) {
            System.out.println(item);
        }
    }

}
