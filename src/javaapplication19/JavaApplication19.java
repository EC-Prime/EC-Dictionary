package javaapplication19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaApplication19 {

    static int option;
    static String term, def;
    static Scanner s = new Scanner(System.in);
    static HashMap<String, String> terms = new HashMap<>();

    static void SeedData() {
        //sample data
        terms.put("Offside", "A rule violation where an attacking player is closer to the opponent's goal line than both the ball and the second-to-last defender at the exact moment the ball is passed to them.");
        terms.put("Clean Sheet", "A term used when a goalkeeper and the defensive line prevent the opposing team from scoring a single goal during the entire match.");
        terms.put("Nutmeg", "A clever dribbling trick where a player kicks or rolls the ball directly through an opponent's legs.");
        terms.put("Pitch", "The traditional name for the playing field where the game is played.");
        terms.put("Hat-trick", "When a single player scores three goals in one match.");
    }

    static void menu() {
        while (true) {
            System.out.println("***********************************************");
            System.out.println(" Welcome to EC Dictionary! My niche dictionary ");
            System.out.println("***********************************************");
            System.out.println("1. Add new term and definition");
            System.out.println("2. Search for a word");
            System.out.println("3. Remove a word");
            System.out.println("4. Display all terms & definitions");
            System.out.println("5. Update");
            System.out.println("6. Exit");
            System.out.print("Option: ");

            try {
                option = s.nextInt();
                s.nextLine();
                switch (option) {
                    case 1:
                        add();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        remove();
                        break;
                    case 4:
                        displayAll();
                        break;
                    case 5:
                        update();
                        break;
                    case 6:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid Input! please enter Options(1-5)");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again! ");
                s.nextLine();
            }
        }

    }

    static void add() {
        System.out.print("Enter a term to add: ");
        term = s.nextLine();

        System.out.print("Enter the definition of " + term + ": ");
        String def = s.nextLine();

        if (terms.containsKey(term)) {
            System.out.println("Term is already added to dictionary");
        } else {
            terms.put(term, def);
            System.out.println("New Term Added!");
            System.out.println(term + ": " + def);
            saveToFile();
        }
    }

    static void saveToFile() {
        try {
            FileWriter writer = new FileWriter("dictionary.txt");

            // loop through Terms, write each entry as "term:def\n"
            for (String term : terms.keySet()) {
                writer.write(term + ":" + terms.get(term) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving dictionary: " + e.getMessage());
        }
    }

    static void loadFromFile() {
        try {
            File file = new File("dictionary.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(":", 2);
                terms.put(parts[0], parts[1].trim());

            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No saved dictionary found - starting fresh.");
            SeedData();
        }
    }

    static void search() {
        System.out.print("Search for a term: ");
        String searchTerm = s.nextLine();

        if (terms.containsKey(searchTerm)) {
            System.out.println(searchTerm + ": " + terms.get(searchTerm));
        } else {
            System.out.println("Term does not Exist!");
        }
    }

    static void remove() {
        System.out.print("Enter a term to remove: ");
        String searchTerm = s.nextLine();

        if (terms.containsKey(searchTerm)) {
            terms.remove(searchTerm);

            System.out.println(searchTerm + "successfully removed!");
            saveToFile();
        } else {
            System.out.println(searchTerm + " is not in the dictionary!");
        }

    }

    static void displayAll() {
        for (String t : terms.keySet()) {
            System.out.println(t + ": " + terms.get(t));
        }
    }

    static void update() {
        System.out.print("Enter the term you would like to update: ");
        String oldTerm = s.nextLine();

        if (terms.containsKey(oldTerm)) {
            System.out.print("Enter the new definition: ");
            String newDef = s.nextLine();
            terms.put(oldTerm, newDef);
            System.out.println("Term updated!");
            saveToFile();
        } else {
            System.out.println("Term could not be updated as it does not exist!");
        }

    }

    static void exit() {
        System.out.println("Thanks for using the Dictionary!");
        System.exit(0);
    }

    public static void main(String[] args) { 
        loadFromFile();
        menu();
       
    }
}
