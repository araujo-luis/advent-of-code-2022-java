package day01;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day01/Part1.txt");
        BufferedReader br;
        String st;
        PriorityQueue<Integer> caloriesByElf = new PriorityQueue<>(Collections.reverseOrder());
        try {
            br = new BufferedReader(new FileReader(file));
            int counter = 0;
            while ((st = br.readLine()) != null) {
                if (st.equals("")) {
                    caloriesByElf.add(counter);
                    counter = 0;
                    continue;
                }
                counter += Integer.parseInt(st);
            }

            Integer part1 = caloriesByElf.poll();
            System.out.println("Part 1: " + part1);
            System.out.println("Part 2: " + (part1 + caloriesByElf.poll() + caloriesByElf.poll()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
