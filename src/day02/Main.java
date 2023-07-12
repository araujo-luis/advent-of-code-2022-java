package day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    enum GAME {
        ROCK,
        SCISSORS,
        PAPER
    }

    static Map<GAME, Integer> rules = Map.of(GAME.ROCK, 1, GAME.PAPER, 2, GAME.SCISSORS, 3);
    static Map<GAME, Integer> rulesOpposite = Map.of(GAME.ROCK, -1, GAME.PAPER, 0, GAME.SCISSORS, 1);

    static Map<GAME, GAME> result = Map.of(GAME.ROCK, GAME.SCISSORS, GAME.SCISSORS, GAME.PAPER, GAME.PAPER, GAME.ROCK);

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day02/input.txt");
        BufferedReader br;
        String st;
        List<String[]> games = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                String[] game = st.split(" ");
                games.add(game);
            }

            //System.out.println("Part 1: " + games);
            for (String[] game : games) {
                //System.out.println(Arrays.toString(game));
            }

            System.out.println("Part 1: " + solvePart1(games));
            System.out.println("Part 2: " + solvePart2(games));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int solveRPS(GAME player1, GAME player2) {
        if (player1 == player2) return 0;

        if (player2.equals(GAME.ROCK) && player1.equals(GAME.SCISSORS) ||
                player2.equals(GAME.SCISSORS) && player1.equals(GAME.PAPER) ||
                player2.equals(GAME.PAPER) && player1.equals(GAME.ROCK)) {
            return 1;
        } else {
            return -1;
        }
    }

    private static GAME parseGame(String game) {
        switch (game) {
            case "A", "X" -> {
                return GAME.ROCK;
            }
            case "B", "Y" -> {
                return GAME.PAPER;
            }
            case "C", "Z" -> {
                return GAME.SCISSORS;
            }
        }
        return null;
    }

    private static int solvePart1(List<String[]> games) {
        int counter = 0;
        for (String[] game : games) {

            GAME player1 = parseGame(game[0]);
            GAME player2 = parseGame(game[1]);

            int result = solveRPS(player1, player2);

            if(result == 0) {
                counter += 3 + rules.get(player2);
            }else if (result == 1) {
                counter += 6 + rules.get(player2);
            } else {
                counter += rules.get(player2);
            }

        }
        return counter;
    }

    private static int solvePart2(List<String[]> games) {
        int counter = 0;
        for (String[] game : games) {

            GAME player1 = parseGame(game[0]);
            GAME player2 = parseGame(game[1]);

            int state = rulesOpposite.get(player2);

            if (state == 0) {
                player2 = player1;
            }else if(state == 1) {
                player2 = result.get(result.get(player1));
            } else {
                player2 = result.get(player1);
            }


            int value = solveRPS(player1, player2);

            if(value == 0) {
                counter += 3 + rules.get(player2);
            }else if (value == 1) {
                counter += 6 + rules.get(player2);
            } else {
                counter += rules.get(player2);
            }

        }
        return counter;
    }
}
