package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.Book;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<Book> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    Book save(Book entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<Book> saveAll(List<Book> list){
        return repository.saveAll(list);
    }

}
