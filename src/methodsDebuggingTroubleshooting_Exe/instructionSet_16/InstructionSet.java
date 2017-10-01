package methodsDebuggingTroubleshooting_Exe.instructionSet_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class InstructionSet {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opCode = reader.readLine();
        while (!opCode.toLowerCase().equals("end")) {
            String[] codeArgs = opCode.split("\\s+");
            BigInteger result = BigInteger.ZERO;
            switch (codeArgs[0].toUpperCase()) {
                case "INC": {
                    result = new BigInteger(codeArgs[1]).add(BigInteger.ONE);
                    break;
                }
                case "DEC": {
                    result = new BigInteger(codeArgs[1]).subtract(BigInteger.ONE);
                    break;
                }
                case "ADD": {
                    result = new BigInteger(codeArgs[1]).add(new BigInteger(codeArgs[2]));
                    break;
                }
                case "MLA": {
                    result = new BigInteger(codeArgs[1]).multiply(new BigInteger(codeArgs[2]));
                    break;
                }
            }
            System.out.println(result);
            opCode = reader.readLine();
        }
        reader.close();
    }
}