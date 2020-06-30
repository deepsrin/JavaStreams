package com.ds.examples;

import com.ds.examples.pojo.Person;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    /** Predicates are functional interfaces that check for a condition and return a boolean.
     *  They are a part of java.util.function package.
     *  They were introduced so that we don't have to worry about creating functional interfaces
     *  while creating lambda expressions.
     */

    //Simple predicate
    private static boolean isEligibleForVoting(Person p, Predicate votingElig) {
        return votingElig.test(p);
    }

    //and predicate
    private static boolean isEligibleForMembership(Person p, Predicate membershipElig) {
        return membershipElig.test(p);
    }

    //or predicate
    private static boolean isAdult(Person p, Predicate isAdultPredicate) {
        return isAdultPredicate.test(p);
    }

    //negate predicate
    private static boolean isAgeEvenNumber(Person p, Predicate isAgeEvenNumPredicate) {
        return isAgeEvenNumPredicate.negate().test(p);
    }

    //bipredicate
    private static boolean testMinAge(Person p, Integer minAge, BiPredicate minAgeTester) {
        return minAgeTester.test(p, minAge);
    }

    public static void main(String[] args) {
        Predicate<Person> votingElig = person -> person.getAge() > 18;

        Person p1 = new Person("John", 30);
        System.out.println(p1.getName() + " eligible for voting: " + isEligibleForVoting(p1, votingElig));

        //and
        Predicate<Person> greaterThan30 = person -> person.getAge() > 30;
        Predicate<Person> lessThan50 = person -> person.getAge() < 50;

        Predicate<Person> membershipElig = greaterThan30.and(lessThan50);
        System.out.println(p1.getName() + " eligible for membership: " + isEligibleForMembership(p1, membershipElig));

        //or
        Predicate<Person> greaterThan18 = person -> person.getAge() > 18;
        Predicate<Person> lessThan65 = person -> person.getAge() < 65;

        Predicate<Person> isAdultPredicate = greaterThan18.or(lessThan65);
        System.out.println(p1.getName() + " eligible adult : " + isAdult(p1, isAdultPredicate));

        //negate
        Predicate<Person> evenNumberPredicate = person -> person.getAge() % 2 == 0;
        System.out.println(p1.getName() + " even number age: " + isAgeEvenNumber(p1, evenNumberPredicate));

        //Bi-predicate
        BiPredicate<Person, Integer> biPredicateExample = (person, minAge) -> person.getAge() > minAge;
        int minAge = 23;
        System.out.println(p1.getName() + " is older than " + minAge + " : " + testMinAge(p1, minAge, biPredicateExample));
    }
}
