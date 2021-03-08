package comp;

import java.util.*;

/**
 * @author Ganea Florin 2A5
 */
public class Main {
    public static void main(String[] args) {

        Student students = new Student();
        List<Student> studentList = new LinkedList<>();
        studentList = students.stream();
        students.printList(studentList);

        School school = new School();
        Set<School> schoolSet = new TreeSet<>();
        schoolSet = school.stream();
        school.printSet(schoolSet);

        Map<Student, List<School>> studentPref = new HashMap<>();

        Preferences preferences = new Preferences(studentList, schoolSet);
        preferences.createStdPrefMap();
        preferences.printStdPrefMap();
    }

}
