package com.ds.examples.pojo;

public class LambdaExample {

    /**
     * A lambda expression is just an anonymous function, i.e., a function with no name and that is not bound to an identifier.
     * We can pass it to other methods as parameters, therefore, using the power of functional programming in Java.
     * General syntax :
     * () -> {//Function body}
     */

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String[] args) {
        wish(() -> System.out.println("Good morning!")); // () is the anonymous class object.
    }
}
