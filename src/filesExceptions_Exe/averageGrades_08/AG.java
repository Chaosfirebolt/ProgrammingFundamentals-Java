package filesExceptions_Exe.averageGrades_08;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ChaosFire on 21.10.2017 г.
 */
public class AG {

    private static final String RES_DIR = "\\resources_Exe\\08_AG";

    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            String project = System.getProperty("user.dir");
            try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input" + i + ".txt"))) {
                int count = Integer.parseInt(reader.readLine());
                List<Student> students = new ArrayList<>(count);
                for (int j = 0; j < count; j++) {
                    String[] data = reader.readLine().split("\\s+");
                    students.add(new Student(data[0], Arrays.stream(data).skip(1).mapToDouble(Double::parseDouble).toArray()));
                }
                StringBuilder output = new StringBuilder();
                students
                        .stream()
                        .filter(st -> st.getAverageGrade() >= 5.00)
                        .sorted(studentComparator())
                        .forEach(st -> output.append(st.toString()).append(System.lineSeparator()));

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output" + i + ".txt"))) {
                    writer.write(output.toString().trim());
                } catch (IOException exc) {
                    System.out.println(exc.getMessage());
                }
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    private static Comparator<Student> studentComparator() {
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        Comparator<Student> gradeComparator = (st1, st2) -> Double.compare(st2.getAverageGrade(), st1.getAverageGrade());
        return nameComparator.thenComparing(gradeComparator);
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

    @Override
    public String toString() {
        return String.format("%s -> %.2f", this.name, this.averageGrade);
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