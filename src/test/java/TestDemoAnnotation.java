import com.cxd.entity.system.Book;
import com.cxd.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cxd
 * java.lang.NoClassDefFoundError: org/springframework/core/annotation/MergedAnnotations$SearchStrategy
 * @description: 这里测试报这个错，是因为Jar包冲突，可以删掉junit包，根据IDEA提示功能导入Jar包
 * @create: 2022-06-01 21:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDemoAnnotation {

    @Resource
    BookService bookService;

    @Test
    public void getList(){
        List<Book> list = bookService.getList();
        list.forEach(System.out::println);
    }
}
