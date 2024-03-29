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

        School school = new School();
        Set<School> schoolSet = new TreeSet<>();
        schoolSet = school.stream();

        SAP_Problem problem = new SAP_Problem(studentList, schoolSet);
        problem.printStudents();
        problem.printSchools();
        problem.createStdPrefMap();
        problem.printStdPrefMap();
        problem.createSchoolPrefMap();
        problem.printSchoolPrefMap();

    }

}


