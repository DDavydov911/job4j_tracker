package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMapToDouble(pupil -> pupil.getSubjects()
                    .stream().mapToDouble(Subject::getScore))
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil ->
                new Tuple(pupil.getName(),
                        pupil.getSubjects().stream()
                                .mapToDouble(Subject::getScore).average().getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil ->
                new Tuple(pupil.getName(),
                        pupil.getSubjects().stream()
                                .mapToInt(Subject::getScore).sum()))
                .collect(Collectors.toList())
                .stream()
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(entries -> new Tuple(entries.getKey(), entries.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static void main(String[] args) {

    }
}
