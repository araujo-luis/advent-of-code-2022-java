import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Luis", "Araujo");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        List<String> uppercased = names.stream().map(String::toUpperCase).toList();

        names.forEach(name -> {
            System.out.println("name: " + name);
        });

        System.out.println(uppercased);
        System.out.println(names);
    }

    public List<Integer> reduceArray(List<Integer> numbers) {
        if (numbers == null) return null;

        return numbers.stream().reduce(new ArrayList<>(), (list, value) -> {
            if (value > 10) {
                list.add(value);
            }
            System.out.println(value);
            return list;
        }, (list1, list2) -> {
            System.out.println("list1");
            System.out.println(list1);
            System.out.println(list2);
            list1.addAll(list2);
            return list1;
        });
    }

}