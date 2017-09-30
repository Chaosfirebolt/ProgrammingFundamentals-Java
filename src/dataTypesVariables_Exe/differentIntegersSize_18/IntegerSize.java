package dataTypesVariables_Exe.differentIntegersSize_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class IntegerSize {

    private static final BigInteger lowSByte = new BigInteger("-128");
    private static final BigInteger highSByte = new BigInteger("127");
    private static final BigInteger lowByte = new BigInteger("0");
    private static final BigInteger highByte = new BigInteger("255");
    private static final BigInteger lowShort = new BigInteger("-32768");
    private static final BigInteger highShort = new BigInteger("32767");
    private static final BigInteger lowUShort = new BigInteger("0");
    private static final BigInteger highUShort = new BigInteger("65535");
    private static final BigInteger lowInt = new BigInteger("-2147483648");
    private static final BigInteger highInt = new BigInteger("2147483647");
    private static final BigInteger lowUInt = new BigInteger("0");
    private static final BigInteger highUInt = new BigInteger("4294967295");
    private static final BigInteger lowLong = new BigInteger("-9223372036854775808");
    private static final BigInteger highLong = new BigInteger("9223372036854775807");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger input = new BigInteger(reader.readLine());
        reader.close();

        StringBuilder output = new StringBuilder();
        output.append(input.toString()).append(" can fit in:").append(System.lineSeparator());
        int count = 0;

        boolean result = input.compareTo(lowSByte) >= 0 && input.compareTo(highSByte) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* sbyte\r\n" : "");

        result = input.compareTo(lowByte) >= 0 && input.compareTo(highByte) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* byte\r\n" : "");

        result = input.compareTo(lowShort) >= 0 && input.compareTo(highShort) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* short\r\n" : "");

        result = input.compareTo(lowUShort) >= 0 && input.compareTo(highUShort) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* ushort\r\n" : "");

        result = input.compareTo(lowInt) >= 0 && input.compareTo(highInt) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* int\r\n" : "");

        result = input.compareTo(lowUInt) >= 0 && input.compareTo(highUInt) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* uint\r\n" : "");

        result = input.compareTo(lowLong) >= 0 && input.compareTo(highLong) <= 0;
        count = result ? count + 1 : count;
        output.append(result ? "* long\r\n" : "");

        if (count > 0) {
            System.out.print(output);
        } else {
            System.out.print(input.toString() + " can't fit in any type");
        }
    }
}