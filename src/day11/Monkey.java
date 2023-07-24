package day11;

import java.util.List;
import java.util.Queue;

public class Monkey {
    private String name;
    private long inspections;

    public void setInspections(long inspections) {
        this.inspections = inspections;
    }

    public long getInspections() {
        return inspections;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", inspections=" + inspections +
                ", items=" + items +
                ", operation='" + operation + '\'' +
                ", divisibleBy=" + divisibleBy +
                ", ifTrueThrowTo=" + ifTrueThrowTo +
                ", ifFalseThrowTo=" + ifFalseThrowTo +
                '}';
    }



    public Monkey(String name) {
        this.name = name;
    }

    private Queue<Long> items;

    private String operation;
    private int divisibleBy;

    private int ifTrueThrowTo;

    private int ifFalseThrowTo;

    public void setItems(Queue<Long> items) {
        this.items = items;
    }

    public Queue<Long> getItems() {
        return items;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setDivisibleBy(int divisibleBy) {
        this.divisibleBy = divisibleBy;
    }

    public void setIfTrueThrowTo(int ifTrueThrowTo) {
        this.ifTrueThrowTo = ifTrueThrowTo;
    }

    public void setIfFalseThrowTo(int ifFalseThrowTo) {
        this.ifFalseThrowTo = ifFalseThrowTo;
    }

    public String getOperation() {
        return operation;
    }

    public int getDivisibleBy() {
        return divisibleBy;
    }

    public int getIfTrueThrowTo() {
        return ifTrueThrowTo;
    }

    public int getIfFalseThrowTo() {
        return ifFalseThrowTo;
    }

    public Monkey() {
        this.inspections = 0;
    }

}
