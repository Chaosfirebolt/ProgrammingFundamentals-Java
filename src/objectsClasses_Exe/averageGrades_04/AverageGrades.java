package objectsClasses_Exe.averageGrades_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class AverageGrades {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            students.add(parseInput(reader.readLine().split("\\s+")));
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        students
                .stream()
                .filter(st -> st.getAverageGrade() >= 5.00)
                .sorted(studentComparator())
                .forEach(st -> output.append(String.format("%s -> %.2f", st.getName(), st.getAverageGrade())).append(System.lineSeparator()));
        System.out.print(output);
    }

    private static Comparator<Student> studentComparator() {
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        Comparator<Student> gradeComparator = Comparator.comparing(Student::getAverageGrade).reversed();
        return nameComparator.thenComparing(gradeComparator);
    }

    private static Student parseInput(String[] input) {
        double[] grades = new double[input.length - 1];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = Double.parseDouble(input[i + 1]);
        }
        return new Student(input[0], grades);
    }
}

class Student {

    private String name;
    private double[] grades;
    private double averageGrade;

    Student(String name, double[] grades) {
        this.setName(name);
        this.setGrades(grades);
        this.setAverageGrade(this.calcAvg());
    }

    private double calcAvg() {
        double total = 0;
        for (double grade : this.grades) {
            total += grade;
        }
        return total / this.grades.length;
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setGrades(double[] grades) {
        this.grades = grades;
    }

    double getAverageGrade() {
        return this.averageGrade;
    }

    private void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}