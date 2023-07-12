package day01;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day01/Part1.txt");
        BufferedReader br;
        String st;
        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
