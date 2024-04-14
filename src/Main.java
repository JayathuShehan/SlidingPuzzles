import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static Scanner input = new Scanner(System.in);

    /*
     * Main method
     * Display the menu method
     * Displays the welcome message
     * Asks for the choice of the user
     */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║ > Press '1' to Show a Test Run                                ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        boolean done = false;
        int option;
        while (!done) {
            System.out.println();
            System.out.print("Enter your choice here: ");  //Getting inputs
            try {
                option = input.nextInt();
                System.out.println();
                if(option < 4 && option >= 0){
                    done = true;
                    choice(option);
                }else{
                    System.out.println("Option does not exists. Please try again!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please only enter Integer inputs!");
                System.out.println();
                input.next();
            }
        }
    }

    /*
     * Choice method
     * Allows the user to choose an option
     */
    static void choice(int option){
        switch (option) {
            case 1 -> {
                //examples/maze10_1.txt
                System.out.println("Reading the test file examples/maze10_1.txt...");
                System.out.println();
                String filepath = "examples/puzzle_2560.txt";
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(filepath));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                SlidingPuzzle puzzle = new SlidingPuzzle(bufferedReader, filepath, "examples");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Solving the puzzle...");
                System.out.println();
                System.out.println("Start at [" + puzzle.beginNode[0] + "," + puzzle.beginNode[1] + "]");
                long startTime = System.nanoTime();
                puzzle.breadthFirstSearch();
                long endTime = System.nanoTime();
                // get the difference between the two nano time values
                long timeElapsed = endTime - startTime;
                System.out.println("Execution time in nanoseconds: " + timeElapsed);
                System.out.println("Execution time in milliseconds: " + TimeUnit.MILLISECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS));
                System.out.println("---------------------------------------------------------------------------");
            }
            default -> System.out.println("Input does not match! Please try again!");
        }
    }
}