package ca.georgiancollege.comp1008gwinter2025gui;

import java.io.Console;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManagement {

    private ArrayList<String> options = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private Path rootPath;
    private Scanner input = new Scanner(System.in);

    public void setOptions(){
        options.add("1) Add School");
        options.add("2) Add campus");
    options.add("3) Add address");
        /*
                "Each school has students organized by student ID\n" +
                "Each student has first & last name\n" +
                "Each student is enrolled in a semester (year-semester)\n" +
                "Each semester, the student has courses\n" +
                "Each course has evaluations\n" +
                "Each evaluation has a grade\n");

         */
    }

    private void setRootPath(){

        rootPath = Path.of("src", "main", "java",
                "ca", "georgiancollege", "comp1008gwinter2025gui", "schoolmanagement");

        try{
            Files.createDirectory(rootPath);
        }
        catch (FileAlreadyExistsException e){
            System.out.println("Root Path already exists");
        }
        catch (IOException e){
            System.out.println("Unknown Exception " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

    }
    public String getOptions(){

        sb.setLength(0); // clear contents

        for(String option : options){
            sb.append(option);
            sb.append("\n");
        }
        return sb.toString();
    }
    private void initialize(){
        setOptions();
        setRootPath();
    }
    public SchoolManagement(){
        initialize();
    }
    private void createSchool() throws IOException{
        System.out.println("Enter a school name");
        sb.setLength(0);
        sb.append(input.nextLine());

        Files.createDirectory(rootPath.resolve(sb.toString()));
    }
    public void run(){
        System.out.println("Welcome!");
        System.out.println("Choose from the following options");
        System.out.println(getOptions());
        int choice = Integer.parseInt(input.nextLine());
        try {
            switch (choice) {
                case 1 -> createSchool();
                default -> System.out.println("Invalid choice");
            };
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
