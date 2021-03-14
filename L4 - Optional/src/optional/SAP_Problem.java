package optional;

import java.util.*;
import java.util.stream.Collectors;

public class SAP_Problem implements Comparator<Student> {
    private final Map<Student, List<School>> studentPref;
    private final List<Student> students;
    private final Set<School> schools;
    private final Map<School, List<Student>> schoolPref;

    /**
     * Descriere problema. Fiind date:
     *
     * @param students o multime de studenti care doresc sa fie admisi la o scoala in functie de preferintele lor
     * @param schools  o multime de scoli care dorec sa admita elevi in functie de nota obtinuta la examen
     *                 Vrem sa gasim o potrivire intre acestea, adica un set de perechi (elev, scoala) astfel incat
     *                 fiecare elev sa fie admis la o scoala, iar capacitatile acestora sa fie respectate
     */

    public SAP_Problem(List<Student> students, Set<School> schools) {
        studentPref = new HashMap<>();
        schoolPref = new TreeMap<>();
        this.schools = schools;
        this.students = students;
    }

    public void sortStudents() {
        students.sort((a, b) -> compare(a, b));
    }

    @Override
    public int compare(Student std1, Student std2) {
        return std1.getName().compareTo(std2.getName());
    }

    public Map<School, List<Student>> getSchoolPref() {
        return schoolPref;
    }

    public Map<Student, List<School>> getStudentPref() {
        return studentPref;
    }

    public void createSchoolPrefMap() {
        List<School> tempList = setToList();
        List<Student> stdList = new ArrayList<>();
        for (Student std : students)
            stdList.add(std);
        stdList.sort((a, b) -> a.compareTo(b));
        for (School school : tempList)
            schoolPref.put(school, stdList);
//        sortStudents();
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

    public void createStdPrefMap() {
        Random random = new Random();
        List<School> schoolsTempList = setToList();
        for (Student student : students) {
            List<School> randomSchools = new ArrayList<>();
            for (School school : schoolsTempList)
                if (random.nextInt() % 2 == 0)
                    randomSchools.add(school);
            if (randomSchools.size() == 0)
                randomSchools.add(schoolsTempList.get(random.nextInt() % schoolsTempList.size()));
            studentPref.put(student, randomSchools);
        }
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

    public void studentsFindAcceptSchools(List<School> schoolList) {
        List<Student> result = students.stream()
                .filter(student -> studentPref.get(student).containsAll(schoolList))
                .collect(Collectors.toList());
        System.out.print("\nStudents who prefer all schools: ");
        if (result.size() == 0)
            System.out.println("none");
        else
            for (Student std : result) {
                System.out.print(std.getName() + " ");
            }
        System.out.println();
    }

    public void schoolsTopPriority(Student student) {
        List<School> schoolList = setToList();
        System.out.print("Schools which prefer student \"" + student.getName() + "\": ");
        List<School> result = schoolList.stream()
                .filter(school -> schoolPref.get(school).indexOf(student) == 0)
                .collect(Collectors.toList());
        if (result.size() == 0)
            System.out.println("none");
        else
            for (School school : result)
                System.out.print(school.getName() + " ");

    }
}