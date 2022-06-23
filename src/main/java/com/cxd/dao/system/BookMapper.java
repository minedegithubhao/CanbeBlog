package com.cxd.dao.system;

import com.cxd.entity.system.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Long bookId);

    int insert(Book record);

    Book selectByPrimaryKey(Long bookId);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);
}