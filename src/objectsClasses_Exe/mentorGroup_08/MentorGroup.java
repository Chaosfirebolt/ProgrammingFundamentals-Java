package objectsClasses_Exe.mentorGroup_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ChaosFire on 11.10.2017 г.
 */
public class MentorGroup {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, Student> students = new HashMap<>();
        List<String> studentNames = new ArrayList<>();
        while (!input.equals("end of dates")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            if (!students.containsKey(name)) {
                students.put(name, new Student(name));
                studentNames.add(name);
            }
            if (data.length > 1) {
                String[] dates = data[1].split(",");
                List<Date> datesAttended = students.get(name).getDatesAttended();
                for (String date : dates) {
                    try {
                        datesAttended.add(DATE_FORMAT.parse(date));
                    } catch (ParseException ignored) {
                    }
                }
            }

            input = reader.readLine();
        }

        input = reader.readLine();
        while (!input.equals("end of comments")) {
            String[] data = input.split("-");
            Student student = students.get(data[0]);
            if (student != null) {
                student.getComments().add(data[1]);
            }

            input = reader.readLine();
        }
        reader.close();

        studentNames.sort(Comparator.naturalOrder());
        StringBuilder output = new StringBuilder();
        for (String name : studentNames) {
            output.append(name).append(System.lineSeparator());
            Student student = students.get(name);

            output.append("Comments:").append(System.lineSeparator());
            List<String> comments = student.getComments();
            for (String comment : comments) {
                output.append("- ").append(comment).append(System.lineSeparator());
            }

            List<Date> dates = student.getDatesAttended();
            dates.sort(Comparator.naturalOrder());
            output.append("Dates attended:").append(System.lineSeparator());
            for (Date date : dates) {
                output.append("-- ").append(DATE_FORMAT.format(date)).append(System.lineSeparator());
            }
        }
        System.out.print(output);
    }
}

class Student {

    private String name;
    private List<String> comments;
    private List<Date> datesAttended;

    Student(String name) {
        this.setName(name);
        this.setComments(new ArrayList<>());
        this.setDatesAttended(new ArrayList<>());
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    List<String> getComments() {
        return this.comments;
    }

    private void setComments(List<String> comments) {
        this.comments = comments;
    }

    List<Date> getDatesAttended() {
        return this.datesAttended;
    }

    private void setDatesAttended(List<Date> datesAttended) {
        this.datesAttended = datesAttended;
    }
}