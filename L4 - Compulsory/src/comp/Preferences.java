package comp;

import java.util.*;

public class Preferences {
    private Map<Student, List<School>> studentPref;
    private List<Student> students;
    private Set<School> schools;

    public Preferences(List<Student> students, Set<School> schools) {
        studentPref = new HashMap<>();
        this.schools = schools;
        this.students = students;
    }

    public void createStdPrefMap() {
        List<School> tempList = setToList();
        studentPref.put(students.get(0), Arrays.asList(tempList.get(0), tempList.get(1), tempList.get(2)));
        studentPref.put(students.get(1), Arrays.asList(tempList.get(0), tempList.get(1), tempList.get(2)));
        studentPref.put(students.get(2), Arrays.asList(tempList.get(0), tempList.get(1)));
        studentPref.put(students.get(3), Arrays.asList(tempList.get(0), tempList.get(2)));
    }

    public void printStdPrefMap() {
        for (Map.Entry<Student, List<School>> entry : studentPref.entrySet()) {
            System.out.print(entry.getKey().getName() + " prefers: ");
            for (School school : entry.getValue())
                System.out.print(school.getName() + " ");
            System.out.println();
        }
    }

    private List setToList() {
        List<School> list = new ArrayList<>();
        Iterator<School> iterator = schools.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

}
