package methodsDebuggingTroubleshooting_Lab.priceChangeAlert_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class ChangeAlert {

    private static final DecimalFormat format = new DecimalFormat("0.################");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        double threshold = Double.parseDouble(reader.readLine());
        double lastPrice = Double.parseDouble(reader.readLine());
        for (int i = 0; i < count - 1; i++) {
            double currPrice = Double.parseDouble(reader.readLine());
            double difference = calcDifference(lastPrice, currPrice);
            boolean isChangeMajor = isChangeMajor(threshold, difference);
            String message = getMessage(currPrice, lastPrice, difference * 100, isChangeMajor);
            System.out.println(message);
            lastPrice = currPrice;
        }
        reader.close();
    }

    private static String getMessage(double currPrice, double lastPrice, double difference, boolean isChangeMajor) {
        String to = "";
        if (difference == 0) {
            to = String.format("NO CHANGE: %s", format.format(currPrice));
        }
        else if (!isChangeMajor) {
            to = String.format("MINOR CHANGE: %s to %s (%.2f%%)", format.format(lastPrice), format.format(currPrice), difference);
        }
        else if (difference > 0) {
            to = String.format("PRICE UP: %s to %s (%.2f%%)", format.format(lastPrice), format.format(currPrice), difference);
        }
        else if (difference < 0) {
            to = String.format("PRICE DOWN: %s to %s (%.2f%%)", format.format(lastPrice), format.format(currPrice), difference);
        }
        return to;
    }

    private static boolean isChangeMajor(double threshold, double difference) {
        return Math.abs(difference) >= threshold;
    }

    private static double calcDifference(double lastPrice, double currPrice) {
        return (currPrice - lastPrice) / lastPrice;
    }
}