package dataTypesVariables_Exe.exchangeVarValues_07;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class ChangeVarValues {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.printf("Before:\r\na = %d\r\nb = %d\r\n", a, b);
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("After:\r\na = %d\r\nb = %d\r\n", a, b);
    }
}