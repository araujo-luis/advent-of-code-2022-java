package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day03/input.txt");
        BufferedReader br;
        String st;
        var finalCompartments = new ArrayList<String>();

        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                String[] array = st.split("");
                Map<String, Integer> rucksack1 = new HashMap<>();
                Map<String, Integer> rucksack2 = new HashMap<>();
                for (int i = 0; i < array.length; i++) {
                    if (i <= (array.length / 2) - 1)
                        parseCompartments(rucksack1, array[i]);
                    else
                        parseCompartments(rucksack2, array[i]);
                }

                for (var entry : rucksack2.entrySet()) {
                    if (rucksack1.containsKey(entry.getKey()))
                        finalCompartments.add(entry.getKey());
                }
            }

            int counter = 0;
            for (String value : finalCompartments) {
                int priority = value.codePointAt(0) - 96;

                if (priority < 0) {
                    priority += 58;
                }
                counter += priority;

            }

            System.out.println("Part 1: " + counter);



            int reads = 0;

            /*

            for
                Read 1st line
                Convert 1st line to Map  {'a': 1}

                Read 2nd line
                Compare every element with Map
                Store matched character in a list

                Read 3rd line
                Compare every element with store list
                keep the ones that match
             */

            Map<String, Integer> rucksack1 = new HashMap<>();
            Map<String, Integer> rucksack2 = new HashMap<>();
            Map<String, Integer> rucksack3 = new HashMap<>();

            List<String> resultPart2 = new ArrayList<>();
            Map<String, Integer> matches = new HashMap<>();
            Set<String> finalMatches = new HashSet<>();

            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {

                reads++;
                String[] array = st.split("");

                for (String s : array) {
                    if (reads == 1){
                        parseCompartmentsPart2(rucksack1, s);
                    }
                    else if (reads == 2) {
                        if (rucksack1.get(s) != null) {
                            matches.merge(s, 1, Integer::sum);
                        }
                    } else {
                        System.out.println(s);
                        System.out.println("letter " + s);
                        System.out.println("letter " + matches);
                        if (matches.get(s) != null) {
                            finalMatches.add(s);
                        }

                    }
                }

                if(reads == 3){
                    resultPart2.addAll(finalMatches);
                    finalMatches.clear();
                    rucksack1.clear();
                    matches.clear();
                    reads = 0;
                }



            }

            System.out.println("finalMatches" + resultPart2);

            int counter2 = 0;
            for (String value : resultPart2) {
                int priority = value.codePointAt(0) - 96;

                if (priority < 0) {
                    priority += 58;
                }
                counter2 += priority;
            }

            System.out.println("finalMatches" + counter2);



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void parseCompartments(Map<String, Integer> rucksack1, String character) {
        rucksack1.merge(character, 1, Integer::sum);
    }


    private static void parseCompartmentsPart2(Map<String, Integer> rucksack1, String character) {
        rucksack1.merge(character, 1, Integer::sum);
    }

}
