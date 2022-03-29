import com.tifa.TifaApplication;
import com.tifa.framework.web.mapper.UserMapper;
import com.tifa.framework.web.pojo.Category;
import com.tifa.framework.web.service.UserService;
import com.tifa.framework.web.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis测试类。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TifaApplication.class)
public class mybatisTest {


    @Autowired
    private UserMapper userService;

//测试数据源和impl功能。
    @Test
    public void testConnection() throws IOException {
        System.out.println(userService.selectById(1));
    }
}
