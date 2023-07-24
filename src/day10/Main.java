package day10;

import day09.Point;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day10/input.txt");
        BufferedReader br;
        String st;

        try {
            br = new BufferedReader(new FileReader(file));

            List<List<String>> commands = new ArrayList<>();

            while ((st = br.readLine()) != null) {
                var command = st.split(" ");
                commands.add(List.of(command));

            }
            System.out.println(commands);

            int cycles = 0;
            int X = 1;
            int signal = 0;
            int signalBreak = 20;
            int counter = 0;
            int breakCounter = 0;

            for (var command : commands) {
                if (command.get(0).equals("noop")) {
                    cycles++;
                    continue;
                }
                cycles++;

                //System.out.println("X->"+Integer.parseInt(command.get(1)));
                if (cycles >= signalBreak ) {
                    //System.out.println(" 1");
                    System.out.println("x is: " + X + " SIGNAL BREAK: " + signalBreak + " TOTAL: " + (X * signalBreak));
                    signal += (X * signalBreak);
                    signalBreak = signalBreak + 40;
                }
                cycles++;

                if (cycles >= signalBreak ) {
                    //System.out.println(" 2"+ command);
                    System.out.println("x is: " + X + " SIGNAL BREAK: " + signalBreak + " TOTAL: " + (X * signalBreak));
                    signal += (X * signalBreak);
                    signalBreak = signalBreak + 40;
                }
                X = X + Integer.parseInt(command.get(1));

            }

            System.out.println("PART 1: " + signal);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
