package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(28, "Masha"));
        input.add(new Student(128, "Peta"));
        List<Student> expected = List.of(
                new Student(128, "Peta"),
                new Student(28, "Masha")
        );
        List<Student> res = StudentLevel.levelOf(input, 20);
        System.out.println(res);
        assertThat(res, is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 1), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(128, "Peta"));
        List<Student> expected = List.of(new Student(128, "Peta"));
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }
}