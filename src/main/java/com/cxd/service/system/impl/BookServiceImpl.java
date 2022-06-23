package com.cxd.service.system.impl;

import com.cxd.dao.system.BookMapper;
import com.cxd.entity.system.Book;
import com.cxd.service.system.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cxd
 * @description:
 * @create: 2022-06-01 22:55
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> getList() {
        return bookMapper.selectAll();
    }
}
