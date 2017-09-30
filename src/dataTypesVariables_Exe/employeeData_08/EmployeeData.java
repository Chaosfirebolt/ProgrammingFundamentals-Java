package dataTypesVariables_Exe.employeeData_08;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class EmployeeData {

    public static void main(String[] args) {
        String firstName = "Amanda";
        String lastName = "Jonson";
        byte age = 27;
        char gender = 'f';
        String id = "8306112507";
        String personalNumber = "27563571";

        System.out.printf("First name: %s\r\nLast name: %s\r\nAge: %d\r\nGender: %c\r\nPersonal ID: %s\r\nUnique Employee number: %s",
                firstName, lastName, age, gender, id, personalNumber);
    }
}