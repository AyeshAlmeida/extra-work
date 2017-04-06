package com.sample.rxjs.initializers;

import com.sample.rxjs.repositories.AppRepository;
import com.sample.rxjs.repositories.BookRepository;
import com.sample.rxjs.service.MockService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Order(2)
@Component
public class DbInitializer implements ApplicationRunner {
    @Resource
    AppRepository appRepository;
    @Resource
    BookRepository bookRepository;

    @Resource
    MockService mockService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        mockService.getApplications(1).forEach(appRepository::save);
        mockService.getBooks(1).forEach(bookRepository::save);
    }
}
