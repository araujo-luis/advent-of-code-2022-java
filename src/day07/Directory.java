package day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends FileType {
    private Directory parent;

    private Map<String, FileType> files;

    public Map<String, FileType> getFiles() {
        return files;
    }

    public void addFiles( FileType file) {
        files.put(file.getName(), file);
    }
    public Directory getParent() {
        return parent;
    }

    public Directory(String name, Directory parent) {
        super(name, 0);
        this.parent = parent;
        this.files = new HashMap<>();
    }

    public Directory(String name) {
        super(name, 0);
        this.files = new HashMap<>();
    }

    public Directory() {
        super();
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + this.getName() + '\'' +
                ", size=" + this.size() +
                ", parent=" + parent.getName() +
                ", fileTypes=" + files.size() +
                '}';
    }

    public long size() {
        long counter = 0;

        for (var file : files.values()) {
            counter += file.size();
        }

        return counter;
    }

}
