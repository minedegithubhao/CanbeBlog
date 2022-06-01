import com.cxd.entity.system.Book;
import com.cxd.service.BookService;
import com.cxd.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author cxd
 * @description:
 * @create: 2022-06-01 21:34
 */
public class TestDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);

    @Test
    public void getAll(){
        List<Book> list = bookService.getList();
        list.forEach(System.out::println);
    }
}
