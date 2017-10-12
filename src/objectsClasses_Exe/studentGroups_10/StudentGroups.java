package objectsClasses_Exe.studentGroups_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ChaosFire on 12.10.2017 г.
 */
public class StudentGroups {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final Map<String, String> MONTHS_MAP = initMonthsMap();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Town> towns = new ArrayList<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            if (input.contains("=>")) {
                String[] data = input.split("\\s*=>\\s*");
                towns.add(new Town(data[0], Integer.parseInt(data[1].split("\\s+")[0])));
            } else {
                Town town = towns.get(towns.size() - 1);
                String[] data = input.split("\\s*\\|\\s*");
                Student student = new Student(data[0], data[1], parseDate(formatDateString(data[2])));
                town.getStudents().add(student);
            }

            input = reader.readLine();
        }

        StringBuilder output = new StringBuilder();
        int groupCount = 0;
        towns.sort(Comparator.comparing(Town::getTownName));
        for (Town town : towns) {
            List<List<Student>> groups = town.createGroups();
            for (List<Student> group : groups) {
                groupCount++;
                StringBuilder emails = new StringBuilder();
                for (Student student : group) {
                    emails.append(student.getEmail()).append(", ");
                }
                emails.delete(emails.length() - 2, emails.length());
                output.append(String.format("%s => %s", town.getTownName(), emails)).append(System.lineSeparator());
            }
        }
        System.out.printf("Created %d groups in %d towns:\r\n", groupCount, towns.size());
        System.out.print(output);
    }

    private static String formatDateString(String string) {
        String[] data = string.split("-");
        data[0] = padLeft(data[0]);
        data[1] = MONTHS_MAP.get(data[1]);
        return String.join("-", data);
    }

    private static String padLeft(String string) {
        return string.length() < 2 ? "0" + string : string;
    }

    private static Map<String, String> initMonthsMap() {
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> monthsMap = new HashMap<>();
        for (int i = 0; i < months.length; i++) {
            monthsMap.put(months[i], padLeft(Integer.toString(i + 1)));
        }
        return monthsMap;
    }

    private static Date parseDate(String input) {
        Date date;
        try {
            date = DATE_FORMAT.parse(input);
        } catch (ParseException exc) {
            date = null;
        }
        return date;
    }
}

class Town {

    private String townName;
    private int seatCount;
    private List<Student> students;

    Town(String townName, int seatCount) {
        this.setTownName(townName);
        this.setSeatCount(seatCount);
        this.setStudents(new ArrayList<>());
    }

    List<List<Student>> createGroups() {
        List<List<Student>> groups = new ArrayList<>();
        groups.add(new ArrayList<>());
        this.students.sort(studentComparator());
        for (Student student : this.students) {
            List<Student> group = groups.get(groups.size() - 1);
            if (group.size() == this.seatCount) {
                group = new ArrayList<>();
                groups.add(group);
            }
            group.add(student);
        }
        return groups;
    }

    private Comparator<Student> studentComparator() {
        Comparator<Student> dateComparator = Comparator.comparing(Student::getRegDate);
        Comparator<Student> nameComparator = Comparator.comparing(Student::getStudentName);
        Comparator<Student> emailComparator = Comparator.comparing(Student::getEmail);
        return dateComparator.thenComparing(nameComparator).thenComparing(emailComparator);
    }

    String getTownName() {
        return this.townName;
    }

    private void setTownName(String townName) {
        this.townName = townName;
    }

    private void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    List<Student> getStudents() {
        return this.students;
    }

    private void setStudents(List<Student> students) {
        this.students = students;
    }
}

class Student {

    private String studentName;
    private String email;
    private Date regDate;

    Student(String studentName, String email, Date regDate) {
        this.setStudentName(studentName);
        this.setEmail(email);
        this.setRegDate(regDate);
    }

    String getStudentName() {
        return this.studentName;
    }

    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    String getEmail() {
        return this.email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    Date getRegDate() {
        return this.regDate;
    }

    private void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}