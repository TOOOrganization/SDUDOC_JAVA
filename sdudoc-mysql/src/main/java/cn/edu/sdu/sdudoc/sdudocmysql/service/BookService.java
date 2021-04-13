package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocdao.entity.Book;
import cn.edu.sdu.sdudoc.sdudocdao.entity.BookExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.BookMapper;

import java.util.Date;
import java.util.List;

public interface BookService extends BookMapper {
    @Override
    long countByExample(BookExample example);

    @Override
    int deleteByExample(BookExample example);

    @Override
    int deleteByPrimaryKey(Date addtime);

    @Override
    int insert(Book record);

    @Override
    int insertSelective(Book record);

    @Override
    List<Book> selectByExample(BookExample example);

    @Override
    Book selectByPrimaryKey(Date addtime);

    @Override
    int updateByExampleSelective(Book record, BookExample example);

    @Override
    int updateByExample(Book record, BookExample example);

    @Override
    int updateByPrimaryKeySelective(Book record);

    @Override
    int updateByPrimaryKey(Book record);
}
