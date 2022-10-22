package com.bijay.reactiveengine.reactivepractises;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> numbers = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream()
                .toList();

        System.out.println("List is: " + numbers);
        System.out.println("Size is: " + numbers.size());

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
