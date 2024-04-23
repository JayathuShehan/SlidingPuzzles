import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static String filePath;

    /*
    -------------------------------------
    | Main method                       |
    | Display the menu method           |
    | Displays the welcome message      |
    | Asks for the choice of the user   |
    -------------------------------------
     */
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|                             SLIDING PUZZLES                              |");
        System.out.println("----------------------------------------------------------------------------");

        BufferedReader bufferedReader = getFilePath();
        String filepath = filePath;

        SlidingPuzzle puzzle = new SlidingPuzzle(bufferedReader, filepath, "benchmark_series");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Solving the puzzle...");
        System.out.println();
        int x = puzzle.beginNode[0] + 1;
        int y = puzzle.beginNode[1] + 1;
        System.out.println("1.\tStart at [" + x + "," + y + "]");
        long startTime = System.nanoTime();
        puzzle.breadthFirstSearch();
        long endTime = System.nanoTime();
        // get the difference between the two nano time values
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + TimeUnit.MILLISECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS));
        System.out.println("---------------------------------------------------------------------------");
    }

// This return bufferedReader object and also update file path
    private static BufferedReader getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Please select a file from below :");
        System.out.println("1. puzzle_10");
        System.out.println("2. puzzle_20");
        System.out.println("3. puzzle_40");
        System.out.println("4. puzzle_80");
        System.out.println("5. puzzle_160");
        System.out.println("6. puzzle_320");
        System.out.println("7. puzzle_640");
        System.out.println("8. puzzle_1280");
        System.out.println("9. puzzle_2560");
        System.out.print("Please type file name you want here : ");
        String filename = scanner.next();
        System.out.println("-----------------------------------------------");

        filePath = "examples\\" + filename + ".txt";

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Please check the name.");
            return getFilePath();
        }
        return bufferedReader;
    }
}