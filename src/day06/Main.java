package day06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day06/input.txt");
        BufferedReader br;
        String st;

        String[] values = new String[0];
        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                values = st.split("");
            }

            int result = solve(values, 4);
            System.out.println("PART 1: " + result);

            int result2 = solve(values, 14);
            System.out.println("PART 2: " + result2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int solve(String[] values, int marker) {
        int result = -1;
        for (var i = 0; i < values.length - marker - 1; i++) {
            var valuesSet = new HashSet<>();
            for (var j = 0; j < marker; j++) {
                valuesSet.add(values[i + j]);
            }
            if (valuesSet.size() == marker) {
                result = i + marker;
                break;
            }
        }
        return result;
    }
}
