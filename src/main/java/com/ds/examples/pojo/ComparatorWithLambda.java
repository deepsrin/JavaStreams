package com.ds.examples;

import com.ds.examples.pojo.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambda {

    public static void main(String[] args) {


        Person p1 = new Person("John", 25);
        Person p2 = new Person("Tom", 30);

        List<Person> persons = new ArrayList();
        persons.add(p1);
        persons.add(p2);

        //Prior to Java 8 (w/o lambda expressions)
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                Integer age1 = p1.getAge();
                Integer age2 = p2.getAge();
                return ((Integer)age1).compareTo((Integer)(age2));
            }
        });

        //With lambda
        Collections.sort(persons, (a, b) -> ((Integer)a.getAge()).compareTo((Integer)b.getAge());
    }

}
