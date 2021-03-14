package optional;

import java.util.*;
import java.util.stream.IntStream;

public class Student implements Comparable<Student> {
    private String name;
    private float examScore;
    private School assignedSchool;

    public Student() {
    }

    public Student(String name, float examScore) {
        this.name = name;
        this.examScore = examScore;
        assignedSchool = null;
    }

    public void setAssignedSchool(School assignedSchool) {
        this.assignedSchool = assignedSchool;
    }

    public School getAssignedSchool() {
        return assignedSchool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List stream() {
        Random random = new Random();
        var students = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Student("S" + i, 10 * random.nextFloat()))
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();
        for (Student student : students)
            studentList.add(student);
//        Collections.sort(studentList, (a, b) -> compare(a, b));
        return studentList;
    }

    public void setExamScore(float examScore) {
        this.examScore = examScore;
    }

    public float getExamScore() {
        return examScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", examScore=" + examScore +
                '}';
    }


    public int compareTo(Student otherStd) {
        if (this.getExamScore() < otherStd.getExamScore())
            return 1;
        if (this.getExamScore() > otherStd.getExamScore())
            return -1;
        return 0;
    }


}

