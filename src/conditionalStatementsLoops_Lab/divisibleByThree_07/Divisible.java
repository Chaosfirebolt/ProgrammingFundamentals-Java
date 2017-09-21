package conditionalStatementsLoops_Lab.divisibleByThree_07;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class Divisible {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}