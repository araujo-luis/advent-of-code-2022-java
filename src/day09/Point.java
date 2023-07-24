package day09;

import java.util.Objects;

public class Point {
    private int row;
    private  int column;

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row && column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Point{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }

    public Point(int column, int row) {
        this.row = row;
        this.column = column;
    }
}
