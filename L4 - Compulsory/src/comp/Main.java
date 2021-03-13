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

        SAP_Problem problem = new SAP_Problem(studentList, schoolSet);
        problem.createStdPrefMap();
        problem.printStdPrefMap();
        problem.createSchoolPrefMap();
        problem.printSchoolPrefMap();


        problem.studentsFindAcceptSchools(problem.setToList());
        problem.schoolsTopPriority(studentList.get(3));

//        Faker faker = new Faker();
//        String name = faker.name().fullName();
//        System.out.println("funny: "+ name);
    }

}


