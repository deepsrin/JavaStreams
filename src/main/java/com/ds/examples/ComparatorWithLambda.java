package com.ds.examples;

import com.ds.examples.pojo.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambda {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList();
        persons.add(new Person("Tom", 30));
        persons.add(new Person("John", 25));

        //Prior to Java 8 (w/o lambda expressions)
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Integer age1 = p1.getAge();
                Integer age2 = p2.getAge();
                return ((Integer)age1).compareTo((Integer)(age2));
            }
        });

        System.out.println("\nSorted w/o lambda");
        for (Person p : persons) {
            System.out.println("name = " + p.getName() + " age = " + p.getAge());
        }

        persons.add(new Person("Jim", 12));
        //With lambda
        Collections.sort(persons, (a, b) -> ((Integer)a.getAge()).compareTo((Integer)b.getAge()));

        System.out.println("\nSorted with lambda");
        for (Person p : persons) {
            System.out.println("name = " + p.getName() + " age = " + p.getAge());
        }
    }

}
