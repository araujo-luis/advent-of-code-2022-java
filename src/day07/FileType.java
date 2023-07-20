package day07;

public class FileType {
    private String name;
    private long size;

    public FileType(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public FileType() {

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    public long size() {
        return size;
    }
}
