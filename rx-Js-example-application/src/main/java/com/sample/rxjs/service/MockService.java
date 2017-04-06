package com.sample.rxjs.service;

import com.github.javafaker.App;
import com.github.javafaker.Faker;
import com.sample.rxjs.models.Application;
import com.sample.rxjs.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MockService {
    private static final Faker faker;
    static {
        faker = new Faker(Locale.ENGLISH, new Random(System.nanoTime()));
    }

    public List<Application> getApplications(int count) {
        return IntStream.range(0, count)
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .map((i) -> {
                    return new Application(
                            System.nanoTime(),
                            faker.app().name(),
                            faker.app().version(),
                            faker.app().author(),
                            "application"

                    );
                })
                .collect(Collectors.toList());
    }

    public List<Book> getBooks(int count) {
        return IntStream.range(0, count)
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .map((i) -> {
                    return new Book(
                            System.nanoTime(),
                            faker.book().author(),
                            faker.book().title(),
                            faker.book().genre(),
                            "book"

                    );
                })
                .collect(Collectors.toList());
    }
}
