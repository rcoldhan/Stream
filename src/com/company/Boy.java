package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        boys.forEach(boy -> {
                    if (duplicates.containsKey(boy.getName())) {
                        duplicates.put(boy.getName(), duplicates.get(boy.getName()) + 1);
                    } else {
                        duplicates.put(boy.getName(), 0);
                    }
                });

        Map<String, Integer> filteredBoys = new HashMap<>();
        boys.stream()
                .filter(boy -> boy.getAge() >= 18)
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(4)
                .forEach(k -> filteredBoys.put(k, 0));

        filteredBoys.replaceAll((k, v) -> duplicates.get(k)); //заменила v на кол-во тезок
        System.out.println(filteredBoys);
    }
}