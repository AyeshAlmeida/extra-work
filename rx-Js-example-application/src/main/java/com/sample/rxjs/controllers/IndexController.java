package com.sample.rxjs.controllers;

import com.sample.rxjs.models.Application;
import com.sample.rxjs.models.Book;
import com.sample.rxjs.repositories.AppRepository;
import com.sample.rxjs.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Resource
    AppRepository appRepository;
    @Resource
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/application")
    @ResponseBody
    public List<Application> getApplicationData(@RequestParam(name = "author", required = false) String author){
        LOGGER.debug("Searching Applications for Author [{}]", author);
        if(author == null || author.equals("")){
            return appRepository.findAll();
        }else {
            return appRepository.findByAuthor(author);
        }
    }

    @RequestMapping("/book")
    @ResponseBody
    public List<Book> getBookData(@RequestParam(name = "author", required = false) String author){
        LOGGER.debug("Searching Books for Author [{}]", author);
        if(author == null || author.equals("")){
            return bookRepository.findAll();
        }else {
            return bookRepository.findByAuthor(author);
        }
    }

}
