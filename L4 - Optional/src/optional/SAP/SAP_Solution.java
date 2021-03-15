package optional.SAP;

import optional.mainPackage.School;
import optional.mainPackage.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SAP_Solution {
    /**
     * Descriere solutie:
     * Parcurgem lista cu studenti
     * Pentru fiecare student parcurgem preferintele acestora
     * Cand gasim prima preferinta care are capacitate > 0,
     * asignam preferinta atributului "assignedSchool" al studentului
     * Si trecem la urmatorul student
     */
    private List<School> schoolList;
    private List<Student> studentList;
    private Map<Student, List<School>> studentPref;

    public SAP_Solution(SAP_Problem problem) {
        this.studentList = problem.getStudents();
        this.schoolList = problem.setToList();
        this.studentPref = problem.getStudentPref();
    }

    public void createSolution() {
        for (Student student : studentList) {
            for (int i = 0; i < studentPref.get(student).size(); i++) {
                School prefSchool = studentPref.get(student).get(i);
                if (prefSchool.getCapacity() > 0) {
//                    matching.put(student, prefSchool);
                    student.setAssignedSchool(prefSchool);
                    prefSchool.setCapacity(prefSchool.getCapacity() - 1);
                    break;
                }
            }
        }
    }

    public void printMatch() {
        System.out.println("\nMatching:");
        for (Student student : studentList)
            if (student.getAssignedSchool() != null)
                System.out.println(student.getName() + " <-> " + student.getAssignedSchool().getName());
            else System.out.println(student.getName() + " not assigned");
    }
}
