
package javaapplication19;

import java.util.HashMap;
import java.util.Scanner;


public class JavaApplication19 {
static int Option;
static String term, def;
static Scanner s = new Scanner(System.in);
static HashMap<String, String> Terms = new HashMap<>();
static void Menu(){
    while(true){
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
    Option = s.nextInt();
    s.nextLine();
    switch(Option){
        case 1: Add();
        break;
        case 2: Search();
        break;
        case 3: Remove();
        break;
        case 4: DisplayAll();
        break;
        case 5: Update();
        break;
        case 6: Exit();
        break;
        default: System.out.println("Invalid Input! please enter Options(1-5)");
    
    }
    }
      
}

 static void Add(){
     System.out.print("Enter a term to add: ");
     term = s.nextLine();
     
     System.out.print("Enter the definition of "+ term);
     String def = s.nextLine();
     
         if(Terms.containsKey(term) && Terms.containsValue(def)){
             System.out.println("Term is already added to dictionary");
         }
         else{
             Terms.put(term, def);
             System.out.println("New Term Added!");
             System.out.println(term +": "+ def);
         }
     }
     
 static void Search(){
     System.out.print("Search for a term: ");
     String searchTerm = s.nextLine();
     
    
         if(Terms.containsKey(searchTerm)){
             System.out.println( searchTerm +": "+ Terms.get(searchTerm));
         }
         else{
             System.out.println("Term does not Exist!");
         }
     }
 
 
 static void Remove(){
     System.out.print("Enter a term to remove: ");
     String searchTerm = s.nextLine();
     
     for (String t : Terms.keySet()){
         if(Terms.containsKey(searchTerm)){
             Terms.remove(searchTerm);
             
         }
     
         else{
             System.out.println(searchTerm +" is not in the dictionary!");
         }
     }
 }
 
 static void DisplayAll(){
     //sample data
     Terms.put("Offside", "A rule violation where an attacking player is closer to the opponent's goal line than both the ball and the second-to-last defender at the exact moment the ball is passed to them.");
     Terms.put("Clean Sheet", "A term used when a goalkeeper and the defensive line prevent the opposing team from scoring a single goal during the entire match.");
     Terms.put("Nutmeg", "A clever dribbling trick where a player kicks or rolls the ball directly through an opponent's legs.");
     Terms.put("Pitch", "The traditional name for the playing field where the game is played.");
     Terms.put("Hat-trick", "When a single player scores three goals in one match.");
     
     for (String t : Terms.keySet()){
         System.out.println(t+ ": "+ Terms.get(t));
     }
 }
 
 static void Update(){
     System.out.print("Enter the term you would like to update: ");
     String OldTerm = s.nextLine();
     
         if(Terms.containsKey(OldTerm)){
             System.out.println("Enter the new definition: ");
             String NewDef = s.nextLine();
             Terms.put(OldTerm, NewDef);
             System.out.println("Term updated!");
         }
         else{
             System.out.println("Term could not be updated as it does not exist!");
         }
     
 }
 
 static void Exit(){
     System.out.println("Thanks for using the Dictionary!");
     System.exit(0);
 }
    public static void main(String[] args) {
        Menu();
    }   
}
