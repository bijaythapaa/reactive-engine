package com.bijay.reactiveengine.reactivepractises;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
//        ReactiveSources.intNumberMono().subscribe(System.out::println);
        ReactiveSources.intNumberMono().subscribe(num -> System.out.println(num),
                err -> System.out.println(err.getMessage()));

        // Get the value from the Mono into an integer variable
        Integer num = ReactiveSources.intNumberMono().block();

        /* Mono could have null or a number */
//        Optional<Integer> num = ReactiveSources.intNumberMono().blockOptional();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
