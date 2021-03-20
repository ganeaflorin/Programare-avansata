package comp;

import java.util.*;
import java.util.stream.IntStream;

public class Student implements Comparator<Student> {
    private String name;

    public Student() {}

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
        Random random = new Random();
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();
        for (Student student : students)
            studentList.add(student);
        Collections.sort(studentList, (a, b) -> compare(a, b));
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

    @Override
    public int compare(Student std1, Student std2) {
        return std1.getName().compareTo(std2.getName());
    }
}
