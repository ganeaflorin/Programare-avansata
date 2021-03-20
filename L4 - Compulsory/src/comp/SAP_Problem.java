package comp;

import java.util.*;
import java.util.stream.Collectors;

public class SAP_Problem {
    private final Map<Student, List<School>> studentPref;
    private final List<Student> students;
    private final Set<School> schools;
    private final Map<School, List<Student>> schoolPref;

    public SAP_Problem(List<Student> students, Set<School> schools) {
        studentPref = new HashMap<>();
        schoolPref = new TreeMap<>();
        this.schools = schools;
        this.students = students;
    }

    public void printStudents() {
        for (Student std : students) {
            System.out.println(std.toString());
        }
    }

    public void printSchools() {
        for (School school : schools) {
            System.out.println(school.toString());
        }
    }

    public void createSchoolPrefMap() {
        List<School> schoolTempList = setToList();
        schoolPref.put(schoolTempList.get(0), Arrays.asList(students.get(3), students.get(0), students.get(1), students.get(2)));
        schoolPref.put(schoolTempList.get(1), Arrays.asList(students.get(0), students.get(2), students.get(1)));
        schoolPref.put(schoolTempList.get(2), Arrays.asList(students.get(0), students.get(1), students.get(3)));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printSchoolPrefMap() {
        for (Map.Entry<School, List<Student>> entry : schoolPref.entrySet()) {
            System.out.print(entry.getKey().getName() + " prefers ");
            for (Student student : entry.getValue())
                System.out.print(student.getName() + " ");
            System.out.println();
        }
    }

    public void createStdPrefMap() {
        List<School> schoolTempList = setToList();
        studentPref.put(students.get(0), Arrays.asList(schoolTempList.get(0), schoolTempList.get(1), schoolTempList.get(2)));
        studentPref.put(students.get(1), Arrays.asList(schoolTempList.get(0), schoolTempList.get(1), schoolTempList.get(2)));
        studentPref.put(students.get(2), Arrays.asList(schoolTempList.get(0), schoolTempList.get(1)));
        studentPref.put(students.get(3), Arrays.asList(schoolTempList.get(0), schoolTempList.get(2)));
    }

    public void printStdPrefMap() {
        for (Map.Entry<Student, List<School>> entry : studentPref.entrySet()) {
            System.out.print(entry.getKey().getName() + " prefers: ");
            for (School school : entry.getValue())
                System.out.print(school.getName() + " ");
            System.out.println();
        }
    }

    public List setToList() {
        List<School> list = new ArrayList<>();
        Iterator<School> iterator = schools.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }


}