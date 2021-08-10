package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public Map<String, Student> maping(List<Student> students) {
        return students.stream()
//                .distinct() //проще всего
                .collect(Collectors.toMap(
                        Student::getSurname,
                        e -> e,
                        (a, b) -> a.equals(b) ? a : b //но так интересней
                ));
    }

    public static void main(String[] args) {
        Student st1 = new Student(40, "Surname1");
        Student st2 = new Student(40, "Surname1");
        Student st3 = new Student(80, "Surname3");
        Student st4 = new Student(90, "Surname4");
        List<Student> students = List.of(st1, st2, st3, st4);
        students.forEach(System.out::println);
        School sc = new School();
        Map<String, Student> expected = new HashMap<>();
        expected.put(st1.getSurname(), st1);
        expected.put(st3.getSurname(), st3);
        expected.put(st4.getSurname(), st4);
        Map<String, Student> result = sc.maping(students);
    }
}
