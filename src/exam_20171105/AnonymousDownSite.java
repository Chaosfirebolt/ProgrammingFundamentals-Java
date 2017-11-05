package exam_20171105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by ChaosFire on 5.11.2017 г.
 */
public class AnonymousDownSite {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int websiteCount = Integer.parseInt(reader.readLine());
        BigInteger securityKey = new BigInteger(reader.readLine());
        BigDecimal totalLoss = BigDecimal.ZERO;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < websiteCount; i++) {
            String[] data = reader.readLine().split("\\s+");
            output.append(data[0]).append(System.lineSeparator());

            BigDecimal pricePerVisit = new BigDecimal(data[2]);
            totalLoss = totalLoss.add(pricePerVisit.multiply(new BigDecimal(data[1])));
        }
        reader.close();
        output.append(String.format("Total Loss: %.20f", totalLoss)).append(System.lineSeparator());
        output.append(String.format("Security Token: %d", securityKey.pow(websiteCount)));
        System.out.print(output);
    }
}