package com.bijay.reactiveengine.reactivepractises;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        /*ReactiveSources.intNumberMono().subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed"));*/

        /*ReactiveSources.userMono().subscribe(
                user -> System.out.println(user.getFirstName()),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed !!"));*/

        /*ReactiveSources.intNumbersFlux().subscribe(
                System.out::println,
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("Completed"));*/

//        Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(
//                System.out::println,
//                throwable -> System.out.println(throwable.getMessage()),
//                () -> System.out.println("Completed"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hooksOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe Happened !!");
        request(1);
    }

    public void hooksOnNext(T value) {
        System.out.println(value.toString() + " received.");
        request(1);
    }
}