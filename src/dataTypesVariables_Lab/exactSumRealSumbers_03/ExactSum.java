package dataTypesVariables_Lab.exactSumRealSumbers_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class ExactSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < count; i++) {
            result = result.add(new BigDecimal(reader.readLine()));
        }
        reader.close();
        System.out.println(result);
    }
}