package day05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day05/input.txt");
        BufferedReader br;
        String st;
        List<List<List<Integer>>> games = new ArrayList<>();

        List<List<String>> lists = new ArrayList<>();
        List<Stack<String>> stacks = new Stack<>();
        List<Integer[]> moves = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(file));
            var totalQueues = (br.readLine().length() + 1) / 4;
            for (var i = 0; i < totalQueues; i++) {
                lists.add(new ArrayList<>());
            }
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                if (st.startsWith("move")) {
                    var values = st.split(" ");

                    moves.add(new Integer[]{Integer.parseInt(values[1]), Integer.parseInt(values[3]), Integer.parseInt(values[5])});

                } else {
                    List<String> values = Arrays.stream(st.split("")).toList();
                    for (var i = 0; i < values.size() && i + 3 <= values.size(); i = i + 4) {
                        if (!values.get(i).equals(" ")) {
                            var position = (i / 4) + 1;
                            lists.get(position - 1).add(values.get(i + 1));
                        }
                    }
                }


            }
            for (var list : lists){
                var stack = new Stack<String>();
                Collections.reverse(list);
                stack.addAll(list);
                stacks.add(stack);
            }
            var stacksPart2 = new ArrayList<Stack<String>>();
            stacks.forEach(stack -> stacksPart2.add((Stack<String>) stack.clone()));
            var part1 = solvePart1(stacks, moves);
            System.out.println("PART 1: " + part1);


            var part2 = solvePart2(stacksPart2, moves);
            System.out.println("PART 2: " + part2);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solvePart1(List<Stack<String>> stacks, List<Integer[]> moves) {

        for (Integer[] move : moves) {
            for (var j = 0; j < move[0]; j++) {
                var from = move[1];
                var to = move[2];
                var value = stacks.get(from - 1).pop();
                stacks.get(to - 1).add(value);
            }
        }

        StringBuilder result = new StringBuilder();
        for (var stack: stacks){
            result.append(stack.peek());
        }
        return result.toString();

    }

    private static String solvePart2(List<Stack<String>> stacks, List<Integer[]> moves) {


        for (Integer[] move : moves) {
            var toMove = new ArrayList<String>();
            for (var j = 0; j < move[0]; j++) {
                var from = move[1];

                var value = stacks.get(from - 1).pop();
                toMove.add(value);

            }
            Collections.reverse(toMove);
            var to = move[2];
            stacks.get(to - 1).addAll(toMove);
        }

        StringBuilder result = new StringBuilder();
        for (var stack: stacks){
            result.append(stack.peek());
        }
        return result.toString();

    }
}
