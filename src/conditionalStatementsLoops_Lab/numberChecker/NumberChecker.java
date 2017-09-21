package conditionalStatementsLoops_Lab.numberChecker;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class NumberChecker {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer.parseInt(reader.readLine());
            System.out.printf("It is a number.");
        } catch (NumberFormatException exc) {
            System.out.printf("Invalid input!");
        }
    }
}