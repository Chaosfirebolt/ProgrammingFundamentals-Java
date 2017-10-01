package methodsDebuggingTroubleshooting_Exe.sequenceOfCommands_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class SequenceOfCommands {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<BigInteger> numbers = new ArrayList<>(count);
        String[] inputNumbers = reader.readLine().split("\\s+");
        for (String inputNumber : inputNumbers) {
            numbers.add(new BigInteger(inputNumber));
        }

        String command = reader.readLine().toLowerCase();
        StringBuilder output = new StringBuilder();
        while (!command.equals("stop")) {
            String[] data = command.split("\\s+");
            int index;
            BigInteger value;
            switch (data[0]) {
                case "multiply":
                    index = Integer.parseInt(data[1]) - 1;
                    value = new BigInteger(data[2]);
                    numbers.set(index, numbers.get(index).multiply(value));
                    break;
                case "add":
                    index = Integer.parseInt(data[1]) - 1;
                    value = new BigInteger(data[2]);
                    numbers.set(index, numbers.get(index).add(value));
                    break;
                case "subtract":
                    index = Integer.parseInt(data[1]) - 1;
                    value = new BigInteger(data[2]);
                    numbers.set(index, numbers.get(index).subtract(value));
                    break;
                case "rshift":
                    value = numbers.remove(numbers.size() - 1);
                    numbers.add(0, value);
                    break;
                case "lshift":
                    value = numbers.remove(0);
                    numbers.add(value);
                    break;
            }
            printList(output, numbers);

            command = reader.readLine().toLowerCase();
        }
        reader.close();
        System.out.print(output);
    }

    private static void printList(StringBuilder output, List<BigInteger> numbers) {
        output.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            output.append(" ").append(numbers.get(i));
        }
        output.append(System.lineSeparator());
    }
}