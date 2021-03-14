package optional;

import java.util.*;
import java.util.stream.IntStream;

public class School implements Comparable<School> {
    String name;
    int capacity;

    public School() {
    }

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set stream() {
        Random random = new Random();
        var schools = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new School("H" + i, random.nextInt(5) % 5 + 1))
                .toArray(School[]::new);
        Set<School> schoolSet = new TreeSet<>();
        for (School school : schools)
            schoolSet.add(school);
        return schoolSet;
    }

    public void printSet(Set<School> set) {
        for (School school : set)
            System.out.println(school.toString());
    }

    @Override
    public int compareTo(School other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
