package org.amch.tdd;

import org.amch.tdd.exception.NonCompliantNumberException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface NumberProcessor {
    String apply(int number);
}
public class Fizzbuzz {


    private static final List<NumberProcessor> RULES = List.of(
            (i -> i % 15 == 0 ? "FizzBuzz" : ""),
            (i -> i % 5 == 0 ? "Buzz" : ""),
            (i -> i % 3 == 0 ? "Fizz" : ""),
            (String::valueOf)
    );

    public String convert(int input) {

        return RULES.stream()
                .map(rule -> rule.apply(input))
                .filter(s -> !s.isEmpty())
                .findFirst()
                .orElse("");
    }

    public String compute(int to) {
        if (to < 1) {
            throw new NonCompliantNumberException();
        }
        return IntStream.rangeClosed(1, to).mapToObj(this::convert).collect(Collectors.joining());
    }
}
