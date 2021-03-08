package comp;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List stream() {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();
        for (Student student : students)
            studentList.add(student);
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        return studentList;
    }

    public void printList(List<Student> list) {
        for (Student student : list)
            System.out.println(student.toString());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
