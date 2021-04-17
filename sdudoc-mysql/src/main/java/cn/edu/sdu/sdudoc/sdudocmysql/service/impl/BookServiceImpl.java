package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.sdudocdao.entity.Book;
import cn.edu.sdu.sdudoc.sdudocdao.entity.BookExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.BookMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public long countByExample(BookExample example) {
        return bookMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BookExample example) {
        return bookMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Date addtime) {
        return bookMapper.deleteByPrimaryKey(addtime);
    }

    @Override
    public int insert(Book record) {
        return 0;
    }

    @Override
    public int insertSelective(Book record) {
        return 0;
    }

    @Override
    public List<Book> selectByExample(BookExample example) {
        return null;
    }

    @Override
    public Book selectByPrimaryKey(Date addtime) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Book record, BookExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Book record, BookExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return 0;
    }
}
