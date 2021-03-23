package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Boy {
    private final String name;
    private final int age;

    Boy(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    @Override
    public final String toString() {
        return name + "-" + age;
    }

    public static void main(final String[] args) {

        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
        //считаю тезок
        Map<String, Integer> duplicates = new HashMap<>();
        for (Boy boy : boys) {
            if (duplicates.containsKey(boy.getName())) {
                duplicates.put(boy.getName(), duplicates.get(boy.getName()) + 1);
            } else {
                duplicates.put(boy.getName(), 0);
            }
        }

        List<Boy> filtered = boys.stream()
                .sorted(Comparator.comparing(Boy::getName)) //по алфавиту
                .filter(x -> x.getAge() >= 18) //18+
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(Boy::getName))),
                        ArrayList::new)); //убрала дубли

        Map<String, Integer> filteredBoys = filtered.stream()
                .limit(4) //оставила 4
                .collect(Collectors.toMap(Boy::getName, Boy::getAge)); //собрала map

        filteredBoys.replaceAll((k, v) -> duplicates.get(k)); //заменила возраст на кол-во тезок
        System.out.println("FINAL: " + filteredBoys);
    }
}