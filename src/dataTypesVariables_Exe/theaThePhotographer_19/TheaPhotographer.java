package dataTypesVariables_Exe.theaThePhotographer_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class TheaPhotographer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger picturesTaken = new BigInteger(reader.readLine());
        BigInteger filterTime = new BigInteger(reader.readLine());
        BigInteger filterFactor = new BigInteger(reader.readLine());
        BigInteger uploadTimePic = new BigInteger(reader.readLine());
        reader.close();

        BigInteger seconds = picturesTaken.multiply(filterTime);
        BigInteger[] data = picturesTaken.multiply(filterFactor).divideAndRemainder(BigInteger.TEN.multiply(BigInteger.TEN));
        BigInteger filteredPictures = data[1].equals(BigInteger.ZERO) ? data[0] : data[0].add(BigInteger.ONE);
        seconds = seconds.add(filteredPictures.multiply(uploadTimePic));

        data = seconds.divideAndRemainder(new BigInteger(Integer.toString(86400)));
        BigInteger days = data[0];
        seconds = data[1];

        data = seconds.divideAndRemainder(new BigInteger(Integer.toString(3600)));
        BigInteger hours = data[0];
        seconds = data[1];

        data = seconds.divideAndRemainder(new BigInteger(Integer.toString(60)));
        BigInteger minutes = data[0];
        seconds = data[1];
        System.out.printf("%d:%s:%s:%s", days, padLeftZeros(hours), padLeftZeros(minutes), padLeftZeros(seconds));
    }

    private static String padLeftZeros(BigInteger num) {
        String string = num.toString();
        return string.length() < 2 ? "0" + string : string;
    }
}