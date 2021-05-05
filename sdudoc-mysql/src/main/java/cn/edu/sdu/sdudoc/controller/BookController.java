package cn.edu.sdu.sdudoc.controller;

import cn.edu.sdu.sdudoc.entity.Book;
import cn.edu.sdu.sdudoc.entity.BookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    BookService service;

    @RequestMapping(value = "count_by_example", method = RequestMethod.POST)
    public long countByExample(BookExample example) {
        return service.countByExample(example);
    }

    @RequestMapping(value = "delete_by_example", method = RequestMethod.POST)
    public int deleteByExample(BookExample example) {
        return service.deleteByExample(example);
    }

    @RequestMapping(value = "delete_by_primary_key", method = RequestMethod.POST)
    public int deleteByPrimaryKey(Date addtime) {
        return service.deleteByPrimaryKey(addtime);
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public int insert(Book record) {
        return service.insert(record);
    }

    @RequestMapping(value = "insert_selective", method = RequestMethod.POST)
    public int insertSelective(Book record) {
        return service.insertSelective(record);
    }

    @RequestMapping(value = "select_by_example", method = RequestMethod.POST)
    public List<Book> selectByExample(BookExample example) {
        return service.selectByExample(example);
    }

    @RequestMapping(value = "select_by_primary_key", method = RequestMethod.POST)
    public Book selectByPrimaryKey(Date addtime) {
        return service.selectByPrimaryKey(addtime);
    }

    @RequestMapping(value = "update_by_example_selective", method = RequestMethod.POST)
    public int updateByExampleSelective(Book record, BookExample example) {
        return service.updateByExampleSelective(record, example);
    }

    @RequestMapping(value = "update_by_example", method = RequestMethod.POST)
    public int updateByExample(Book record, BookExample example) {
        return service.updateByExample(record, example);
    }

    @RequestMapping(value = "update_by_primary_key_selective", method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(Book record) {
        return service.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "update_by_primary_key", method = RequestMethod.POST)
    public int updateByPrimaryKey(Book record) {
        return service.updateByPrimaryKey(record);
    }
}
