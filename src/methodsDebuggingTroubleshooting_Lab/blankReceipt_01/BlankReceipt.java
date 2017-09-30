package methodsDebuggingTroubleshooting_Lab.blankReceipt_01;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class BlankReceipt {

    public static void main(String[] args) {
        printHeader();
        printBody();
        printFooter();
    }

    private static void printHeader() {
        System.out.println("CASH RECEIPT\r\n------------------------------");
    }

    private static void printBody() {
        System.out.println("Charged to____________________\r\nReceived by___________________");
    }

    private static void printFooter() {
        System.out.println("------------------------------\r\n© SoftUni");
    }
}