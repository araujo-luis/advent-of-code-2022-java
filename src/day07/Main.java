package day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        File file = new File("/Users/luisarau/IdeaProjects/Java/src/day07/input.txt");
        BufferedReader br;
        String st;

        try {
            br = new BufferedReader(new FileReader(file));
            Directory rootDirectory = new Directory("/");
            Directory currentDirectory = rootDirectory;

            List<Directory> directories = new ArrayList<>();
            br.readLine();
            while ((st = br.readLine()) != null) {
                var command = st.split(" ");
                if ("$".equals(command[0])) {
                    if ("cd".equals(command[1])) {
                        if ("..".equals(command[2])) {
                            currentDirectory = currentDirectory.getParent();
                        } else {
                            currentDirectory = (Directory) currentDirectory.getFiles().get(command[2]);
                        }
                    }
                } else if ("dir".equals(command[0])) {
                    var newDirectory = new Directory(command[1], currentDirectory);
                    currentDirectory.addFiles(newDirectory);
                    directories.add(newDirectory);
                } else {
                    var newFile = new FileType(command[1], Long.parseLong(command[0]));
                    currentDirectory.addFiles(newFile);
                }
            }

            long count = 0;
            var totalSize = rootDirectory.size();
            var diff = 70000000 - totalSize;
            System.out.println("diff "+ diff);
            for (var de : directories) {
                long size = de.size();
                if (size < 100000) {
                    count += size;
                }
            }

            System.out.println("Part 1: " + count);

            List<Directory> part2 = new ArrayList<>();

            for (var de : directories) {
                long size = de.size();
                if (diff  + size > 30000000 ) {
                    part2.add(de);
                }
            }
            part2.sort(Comparator.comparing(Directory::size));


            System.out.println("Part 2: " + part2.get(0).size());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
