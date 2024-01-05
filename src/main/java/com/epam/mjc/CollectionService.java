package com.epam.mjc;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {

        List<Integer> list1 = new LinkedList<>();

        list.stream().filter(i -> i % 2 == 0).forEach(i -> list1.add(i));

        return list1;

    }

    public List<String> toUpperCaseCollection(List<String> list) {

        List<String> list1 = new LinkedList<>();

        list.stream().map(i -> i.toUpperCase()).forEach(i -> list1.add(i));

        return list1;

    }

    public Optional<Integer> findMax(List<Integer> list) {

        Integer max = list.stream().mapToInt(i -> i).max().orElseThrow();

        Optional<Integer> expected = Optional.of(max);

        return expected;

    }

    public Optional<Integer> findMin(List<List<Integer>> list) {

        List<Integer> flatList = new LinkedList<>();

        flatList = list.stream().flatMap(List::stream).collect(Collectors.toList());

        Integer min = flatList.stream().mapToInt(i -> i).min().orElseThrow();

        Optional<Integer> expected = Optional.of(min);

        return expected;

    }

    public Integer sum(List<Integer> list) {

        Optional result1 = list.stream().reduce((x,y) -> x + y);

        Integer result = (Integer) result1.get();

        return result;

    }
}
