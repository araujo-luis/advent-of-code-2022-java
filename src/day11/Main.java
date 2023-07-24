package day11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day11/input.txt");
        BufferedReader br;
        String st;

        try {
            br = new BufferedReader(new FileReader(file));

            List<Monkey> monkeys = new ArrayList<>();

            Monkey monkey = null;
            while ((st = br.readLine()) != null) {
                //System.out.println(st);
                if (st.startsWith("Monkey")) {
                    var name = st.split("Monkey ")[1];
                    monkey = new Monkey(name);
                }


                if (st.startsWith("  Starting")) {
                    var items = st.split("  Starting items: ")[1];
                    List<Long> ite = Arrays.stream(items.split(", ")).map(Long::parseLong).toList();
                    monkey.setItems(new LinkedList<>(ite));
                }

                if (st.startsWith("  Operation")) {
                    var operation = st.split("  Operation: new = ")[1];
                    monkey.setOperation(operation);
                }


                if (st.startsWith("  Test")) {
                    var test = st.split("  Test: divisible by ")[1];
                    monkey.setDivisibleBy(Integer.parseInt(test));
                }


                if (st.startsWith("    If true")) {
                    var ifTrue = st.split("    If true: throw to monkey ")[1];
                    monkey.setIfTrueThrowTo(Integer.parseInt(ifTrue));
                }


                if (st.startsWith("    If false")) {
                    var ifTrue = st.split("    If false: throw to monkey ")[1];
                    monkey.setIfFalseThrowTo(Integer.parseInt(ifTrue));
                    monkeys.add(monkey);
                }

            }

            //for (var m : monkeys) {
            //    System.out.println(m);
            //}

            var loops = 10000;
            for (var i = 0; i < loops; i++) {
                for (var currentMonkey : monkeys) {
                    for (var item : currentMonkey.getItems()) {

                        var operationResult = solveOperation(currentMonkey.getOperation(), item);
                        var divisible = getDivisible(operationResult);
                        var isDivisible = isDivisibleBy(divisible, currentMonkey.getDivisibleBy());
                        //System.out.println("item " + item + " operation; " + operationResult + " divisible: " + divisible + " isDivisible: " + isDivisible);
                        throwItemsTo(isDivisible, divisible, currentMonkey, monkeys);
                        currentMonkey.setInspections(currentMonkey.getInspections() + 1);
                    }
                    currentMonkey.getItems().clear();

                    //break;

                    //for (var m : monkeys) {
                    //    System.out.println(m);
                    //}
                    //System.out.println("----------------");
                }


            }

            for (var m : monkeys) {
                System.out.println(m);
            }

            monkeys.sort(Comparator.comparing(Monkey::getInspections).reversed());

            BigInteger part1 = BigInteger.valueOf(monkeys.get(0).getInspections()).multiply(BigInteger.valueOf(monkeys.get(1).getInspections()));

            System.out.println("PART 1: " +part1 );


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void throwItemsTo(boolean isDivisible, long divisible, Monkey currentMonkey, List<Monkey> monkeys) {
        var ifTrueThrowTo = currentMonkey.getIfTrueThrowTo();
        var ifFalseThrowTo = currentMonkey.getIfFalseThrowTo();
        //var value = currentMonkey.getItems().poll();

        if (isDivisible) {
            monkeys.get(ifTrueThrowTo).getItems().add(divisible);
            //System.out.println("THROWING " + divisible + " to monkey " + ifTrueThrowTo);
        } else {
            monkeys.get(ifFalseThrowTo).getItems().add(divisible);
            //System.out.println("THROWING " + divisible + " to monkey " + ifFalseThrowTo);
        }
    }


    private static boolean isDivisibleBy(long divisible, int divisibleBy) {
        return divisible % divisibleBy == 0;
    }

    private static long getDivisible(long operationResult) {
        //return (int) Math.floor((float) operationResult / 3); // PART 1
        return operationResult % 9699690; // PART 2
        //return operationResult;
    }
//i = i %2;
    // i%=2;

    private static long solveOperation(String operation, Long item) {
        var split = operation.split(" ");

        Long secondValue;

        if (split[2].equals("old"))
            secondValue = item;
        else
            secondValue = Long.parseLong(split[2]);

        if (split[1].equals("*"))
            return item * secondValue;
        else
            return item + secondValue;

    }


}
