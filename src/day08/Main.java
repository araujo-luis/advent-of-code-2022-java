package day08;

import day07.Directory;
import day07.FileType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day08/input.txt");
        BufferedReader br;
        String st;

        try {
            br = new BufferedReader(new FileReader(file));

            List<List<Integer>> tree = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                var trees = Arrays.stream(st.split("")).map(Integer::parseInt).toList();
                tree.add(trees);
            }

            /*
                3  0  3  7  3
                00 01 02 03 04
                2  5  5  1  2
                10 11 12 13 14
                6  5  3  3  2
                20 21 22 23 24
                3  3  5  4  9
                30 31 32 33 34
                3  5  3  9  0
                40 41 42 43 44
             */
            int counter = 0;
            int outerTrees = (tree.size() * tree.get(0).size()) - ((tree.size() - 2) * (tree.get(0).size() - 2));
            for (var i = 1; i < tree.size() - 1; i++) {
                var row = tree.get(i);
                for (var j = 1; j < row.size() - 1; j++) {

                    // check up
                    boolean isUp = true;
                    for (var up = i - 1; up >= 0; up--) {
                        if (tree.get(i).get(j) <= tree.get(up).get(j)) {
                            isUp = false;
                            break;
                        }
                    }


                    // check right
                    boolean isRight = true;
                    for (var right = j + 1; right < row.size(); right++) {
                        if (tree.get(i).get(j) <= tree.get(i).get(right)) {
                            isRight = false;
                            break;
                        }
                    }

                    // check down
                    boolean isDown = true;
                    for (var down = i + 1; down < tree.size(); down++) {
                        if (tree.get(i).get(j) <= tree.get(down).get(j)) {
                            isDown = false;
                            break;
                        }
                    }

                    // check left
                    boolean isLeft = true;
                    for (var left = j - 1; left >= 0; left--) {
                        if (tree.get(i).get(j) <= tree.get(i).get(left)) {
                            isLeft = false;
                            break;
                        }
                    }

                    if (isUp || isRight || isDown || isLeft) {
                        counter++;
                    }

                }
            }

            System.out.println("Part 1: " + (counter + outerTrees));

            Set<Integer> values = new HashSet<>();

            for (var i = 1; i < tree.size() - 1; i++) {
                var row = tree.get(i);
                for (var j = 1; j < row.size() - 1; j++) {

                    // check up
                    int treesUp = 0;
                    for (var up = i - 1; up >= 0; up--) {
                        treesUp++;
                        if (tree.get(i).get(j) <= tree.get(up).get(j)) {
                            break;
                        }

                    }
                    // check right
                    int treesRight = 0;
                    for (var right = j + 1; right < row.size(); right++) {
                        treesRight++;
                        if (tree.get(i).get(j) <= tree.get(i).get(right)) {
                            break;
                        }
                    }

                    // check down
                    int treesDown = 0;
                    for (var down = i + 1; down < tree.size(); down++) {
                        treesDown++;
                        if (tree.get(i).get(j) <= tree.get(down).get(j)) {
                            break;
                        }
                    }

                    // check left
                    int treeLeft = 0;
                    for (var left = j - 1; left >= 0; left--) {
                        treeLeft++;
                        if (tree.get(i).get(j) <= tree.get(i).get(left)) {
                            break;
                        }
                    }
                    values.add(treesUp * treesRight * treesDown * treeLeft);
                }
            }

            List<Integer> resultPart2 = new ArrayList<>(values);
            Collections.sort(resultPart2, Collections.reverseOrder());
            System.out.println("PART 2: " + resultPart2.get(0));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
