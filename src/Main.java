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
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        SLIDING PUZZLES                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        System.out.println("Reading the test file examples/maze10_1.txt...");
        System.out.println();
        String filepath = "examples/maze10_1.txt";
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
}