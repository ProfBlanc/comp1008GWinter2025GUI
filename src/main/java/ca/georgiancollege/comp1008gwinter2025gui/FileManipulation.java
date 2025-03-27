package ca.georgiancollege.comp1008gwinter2025gui;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileManipulation {

    static Path path = Path.of("src", "main", "java",
            "ca", "georgiancollege", "comp1008gwinter2025gui");

    static void example1() throws IOException {


        System.out.println(path.toAbsolutePath());

        System.out.println("Enter a directory name");
        String folder = new Scanner(System.in).nextLine();

        //way to create
        //Files.createDirectory(path.resolve(folder));
        System.out.println(Files.exists(path.resolve(folder)));
        Files.createDirectories(path.resolve(folder));

    }

    static void example2() throws IOException {

       File[] files = path.toFile().listFiles();

       for(File file : files){
           System.out.println(file.getName());
           System.out.println("Is file? " + file.isFile());
           System.out.println("Is dir? " + file.isDirectory());
           System.out.println("Size of file: " + file.length());
           System.out.println("*".repeat(20));

       }
    }
    static void example3() throws IOException {

        path.resolve("d2").resolve("d20").toFile().renameTo(
                path.resolve("d2").resolve("d200").toFile());


        Files.delete(path.resolve("d1").resolve("d10"));

    }
    static void example4() throws IOException {

        Files.writeString(path.resolve("d1").resolve("text1.txt"),
                "Hello World!\n",
                StandardOpenOption.APPEND
                );

    }
    static void example5() throws IOException {
        //String content = Files.readString(path.resolve("d1/text1.txt"));
       // System.out.println(content);

        List<String> allLines = Files.readAllLines(path.resolve("d1/text1.txt"));

        for(String line : allLines){
            System.out.println(line);
        }

       }
    public static void main(String[] args) {
        try {
            example5();
        }catch (IOException e){
            System.err.println(e.getClass().getSimpleName() +": " + e.getMessage());
        }
    }
}
