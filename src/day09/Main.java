package day09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day09/input.txt");
        BufferedReader br;
        String st;

        try {
            br = new BufferedReader(new FileReader(file));


            List<List<String>> commands = new ArrayList<>();
            int highestRow = 0;
            int highestColumn = 0;
            while ((st = br.readLine()) != null) {
                var command = st.split(" ");
                var steps = Integer.parseInt(command[1]);
                if (steps > highestRow && (command[0].equals("R") || command[0].equals("L")))
                    highestRow = steps;

                if (steps > highestColumn && (command[0].equals("U") || command[0].equals("D")))
                    highestColumn = steps;
                commands.add(Arrays.asList(command));
            }
            System.out.println(commands);
            System.out.println(highestRow);

            System.out.println("Column: " + highestColumn + " Row: " + highestRow);
            int[][] table = new int[1000][1000];
            for (int[] booleans : table) {
                System.out.println(Arrays.toString(booleans));

            }


            /*
                0  0  0  0  0  0
                00 01 02 03 04 05
                0  0  0  0  0  0
                10 11 12 13 14 15
                0  0  0  0  0  0
                20 21 22 23 24 25
                0  0  0  0  0  0
                30 31 32 33 34 35
                0  0  0  0  0  0
                40 41 42 43 44 45
             */


            Map<String, Point> position = new HashMap<>();

            position.put("HEAD", new Point(400, 400));
            position.put("TAIL", new Point(400, 400));


            int counter = 0;
            for (var command : commands) {
                counter++;
                System.out.println(command);

                for (var i = 0; i < Integer.parseInt(command.get(1)); i++) {

                    var head = position.get("HEAD");
                    var tail = position.get("TAIL");
                    // move right
                    if (command.get(0).equals("R")) {
                        var newHeadRow = head.getRow() + 1;
                        head.setRow(newHeadRow);

                        if (Math.abs(head.getRow() - tail.getRow()) == 2 && i == 1) {
                            var newTailRow = tail.getRow() + 1;
                            var newTailColumn = head.getColumn();
                            tail.setRow(newTailRow);
                            tail.setColumn(newTailColumn);
                        }else if (!head.equals(tail) && i == 0) {
                            //System.out.println("IIII" + i);
                        } else if (!head.equals(tail) && Math.abs(head.getRow() - tail.getRow()) == 2){
                            //System.out.println("else" + i);
                            var newTailRow = tail.getRow() + 1;
                            tail.setRow(newTailRow);
                            var newTailColumn = head.getColumn();
                            tail.setColumn(newTailColumn);
                        }
                        var tailPosition = table[tail.getColumn()][tail.getRow()];
                        if (tailPosition == 0) {
                            table[tail.getColumn()][tail.getRow()] = 1;
                        }
                    }
                /*
                                0  0  0  0  0  0
                                00 01 02 03 04 05
                                0  0  0  0  0  0
                                10 11 12 13 14 15
                                0  0  0  0  0  0
                                20 21 22 23 24 25
                                0  0  0  0  0  0
                                30 31 32 33 34 35
                                0  0  0  0  0  0
                                40 41 42 43 44 45
                             */

                    // move up
                    if (command.get(0).equals("U")) {
                        var newHeadColumn = head.getColumn() - 1;
                        head.setColumn(newHeadColumn);

                        if (Math.abs(head.getColumn() - tail.getColumn()) == 2 && i == 1) {
                            System.out.println("ENTRA" + tail.getColumn());
                            var newTailColumn = head.getColumn() + 1;
                            var newTailRow = head.getRow();
                            tail.setColumn(newTailColumn);
                            tail.setRow(newTailRow);
                        } else if (!head.equals(tail) && i == 0) {
                            System.out.println("IIII" + i);
                            //var newTailRow = tail.getRow() - 1;
                            //tail.setRow(newTailRow);
                        } else if (!head.equals(tail) && Math.abs(head.getColumn() - tail.getColumn()) == 2){
                            System.out.println("else" + i);
                            var newTailColumn = tail.getColumn() - 1;
                            tail.setColumn(newTailColumn);
                            var newTailRow = head.getRow();
                            tail.setRow(newTailRow);
                        }

                        var tailPosition = table[tail.getColumn()][tail.getRow()];
                        if (tailPosition == 0) {
                            table[tail.getColumn()][tail.getRow()] = 1;
                        }
                    }


                        /*
                                0  0  0  0  0  0
                                00 01 02 03 04 05
                                0  0  0  0  0  0
                                10 11 12 13 14 15
                                0  0  0  0  0  0
                                20 21 22 23 24 25
                                0  0  0  0  0  0
                                30 31 32 33 34 35
                                0  0  0  0  0  0
                                40 41 42 43 44 45
                             */
                    // move left
                    if (command.get(0).equals("L")) {
                        var newHeadRow = head.getRow() - 1;
                        head.setRow(newHeadRow);

                        if (Math.abs(head.getRow() - tail.getRow()) == 2 && i == 1) {
                            //System.out.println("ENTRA" + tail.getColumn());
                            var newTailRow = head.getRow() + 1;
                            var newTailColumn = head.getColumn();
                            tail.setColumn(newTailColumn);
                            tail.setRow(newTailRow);
                        } else if (!head.equals(tail) && i == 0) {
                            //System.out.println("IIII" + i);
                            //var newTailRow = tail.getRow() - 1;
                            //tail.setRow(newTailRow);
                        } else if (!head.equals(tail) && Math.abs(head.getRow() - tail.getRow()) == 2){
                            //System.out.println("else" + i);
                            var newTailRow = tail.getRow() - 1;
                            tail.setRow(newTailRow);
                            var newTailColumn = head.getColumn();
                            tail.setColumn(newTailColumn);
                        }

                        var tailPosition = table[tail.getColumn()][tail.getRow()];
                        if (tailPosition == 0) {
                            table[tail.getColumn()][tail.getRow()] = 1;
                        }
                    }

                     /*
                                0  0  0  0  0  0
                                00 01 02 03 04 05
                                0  0  0  0  0  0
                                10 11 12 13 14 15
                                0  0  0  0  0  0
                                20 21 22 23 24 25
                                0  0  0  0  0  0
                                30 31 32 33 34 35
                                0  0  0  0  0  0
                                40 41 42 43 44 45
                             */
                    // move left
                    if (command.get(0).equals("D")) {
                        var newHeadRow = head.getColumn() + 1;
                        head.setColumn(newHeadRow);

                        if (Math.abs(head.getColumn() - tail.getColumn()) == 2 && i == 1) {
                            //System.out.println("ENTRA DOWN" + tail.getColumn());
                            var newTailRow = head.getRow();
                            var newTailColumn = head.getColumn() - 1;
                            tail.setColumn(newTailColumn);
                            tail.setRow(newTailRow);
                        } else if (!head.equals(tail) && i == 0) {
                            //System.out.println("IIII" + i);
                            //var newTailRow = tail.getRow() - 1;
                            //tail.setRow(newTailRow);
                        } else if (!head.equals(tail) && Math.abs(head.getColumn() - tail.getColumn()) == 2){
                            //System.out.println("else" + i);
                            var newTailColumn = tail.getColumn() + 1;
                            tail.setColumn(newTailColumn);
                            var newTailRow = head.getRow();
                            tail.setRow(newTailRow);
                        }

                        var tailPosition = table[tail.getColumn()][tail.getRow()];
                        if (tailPosition == 0) {
                            table[tail.getColumn()][tail.getRow()] = 1;
                        }
                    }
                    //if (counter == 7 && i == 0) {
                    //    break;
                    //}
                }
                //if (counter == 7)
                  //  break;
            }

            System.out.println("HEAD: " + position.get("HEAD"));
            System.out.println("TAIL: " + position.get("TAIL"));
            int part1 = 0;
            for (int[] booleans : table) {
                System.out.println(Arrays.toString(booleans));

            }

            for (int[] booleans : table) {
                for (int va: booleans){
                    if(va == 1) part1++;
                }
            }
            System.out.println("PART1: " + part1);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
