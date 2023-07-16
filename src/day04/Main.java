package day04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

        /*

            Data Structure
            [
                [[2,4], [6,8]],
            ]

            1 2 3 - - - - - - -
            - 2 3 4 - - - - - -


            1 2 - - - - - - - -
            - - 3 4 - - - - - -

         */

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day04/input.txt");
        BufferedReader br;
        String st;
        List<List<List<Integer>>> games = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                String[] pair = st.split(",");
                var first = Arrays.stream(pair[0].split("-")).map(Integer::parseInt).toList();
                var second = Arrays.stream(pair[1].split("-")).map(Integer::parseInt).toList();
                games.add(List.of(first, second));
            }

            //System.out.println("Part 1: " + games);
            var result = games.stream().filter(Main::isFullyOverlapped).toList();

            System.out.println("Part 1: "  + " " + result.size());

            var resultPart2 = games.stream().filter(Main::isPartiallyOverlapped).toList();

            System.out.println("Part 2: "  + " " + resultPart2.size());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isFullyOverlapped(List<List<Integer>> game) {
        var firstPair = game.get(0);
        var secondPair = game.get(1);

        if(firstPair.get(0) >= secondPair.get(0)  && firstPair.get(1) <= secondPair.get(1))
            return true;
        else return firstPair.get(0) <= secondPair.get(0) && firstPair.get(1) >= secondPair.get(1);
    }

    private static boolean isPartiallyOverlapped(List<List<Integer>> game) {
        var firstPair = game.get(0);
        var secondPair = game.get(1);

        if(firstPair.get(0) >= secondPair.get(0)  && firstPair.get(1) <= secondPair.get(1))
            return true;
        else if (firstPair.get(0) <= secondPair.get(0) && firstPair.get(1) >= secondPair.get(1))
            return true;
        else return firstPair.get(0) <= secondPair.get(1) && firstPair.get(1) >= secondPair.get(0);
    }
}
