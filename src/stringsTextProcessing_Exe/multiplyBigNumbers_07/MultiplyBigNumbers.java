package stringsTextProcessing_Exe.multiplyBigNumbers_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class MultiplyBigNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigNumber a = new BigNumber(reader.readLine());
        BigNumber b = new BigNumber(reader.readLine());
        reader.close();
        BigNumber result = a.multiply(b);
        System.out.print(result);
    }
}

class BigNumber {

    private String value;

    BigNumber(String value) {
        this.setValue(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

    BigNumber multiply(BigNumber number) {
        String first = this.getLonger(this.value, number.value);
        String second = this.getShorter(this.value, number.value);
        String result = multiply(first, second);
        return new BigNumber(result);
    }

    private String multiply(String first, String second) {
        LinkedList<BigNumber> operands = new LinkedList<>();
        for (int i = second.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(Character.toString(second.charAt(i)));
            LinkedList<Integer> digits = new LinkedList<>();
            for (int count = 0; count < operands.size(); count++) {
                digits.addFirst(0);
            }
            int increase = 0;
            for (int j = first.length() - 1; j >= 0; j--) {
                int b = Integer.parseInt(Character.toString(first.charAt(j)));
                int next = a * b + increase;
                increase = next / 10;
                next %= 10;
                digits.addFirst(next);
            }
            digits.addFirst(increase);
            this.removeStartingZeroes(digits);
            operands.addLast(new BigNumber(this.buildValueString(digits)));
        }
        BigNumber result = operands.removeFirst();
        while (operands.size() > 0) {
            result = result.add(operands.removeFirst());
        }
        return result.toString();
    }

    BigNumber add(BigNumber number) {
        String first = this.getLonger(this.value, number.value);
        int diff = Math.abs(this.value.length() - number.value.length());
        String second = this.padLeftZeroes(this.getShorter(this.value, number.value), diff);
        return new BigNumber(add(first, second));
    }

    @SuppressWarnings("Duplicates")
    private String add(String first, String second) {
        LinkedList<Integer> digits = new LinkedList<>();
        int increase = 0;
        for (int i = first.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(Character.toString(first.charAt(i)));
            int b = Integer.parseInt(Character.toString(second.charAt(i)));
            int next = a + b + increase;
            increase = next / 10;
            next %= 10;
            digits.addFirst(next);
        }
        digits.addFirst(increase);
        this.removeStartingZeroes(digits);
        return this.buildValueString(digits);
    }

    private void removeStartingZeroes(LinkedList<Integer> digits) {
        while (digits.size() > 1 && digits.getFirst() == 0) {
            digits.removeFirst();
        }
    }

    private String buildValueString(LinkedList<Integer> digits) {
        StringBuilder result = new StringBuilder();
        for (Integer digit : digits) {
            result.append(digit);
        }
        return result.toString();
    }

    private String getShorter(String value, String otherValue) {
        return value.length() <= otherValue.length() ? value : otherValue;
    }

    private String getLonger(String value, String otherValue) {
        return value.length() > otherValue.length() ? value : otherValue;
    }

    private String padLeftZeroes(String value, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("0");
        }
        sb.append(value);
        return sb.toString();
    }

    private void setValue(String value) {
        this.value = value;
    }
}