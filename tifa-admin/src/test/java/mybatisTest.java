
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tifa.TifaApplication;
import com.tifa.framework.web.mapper.UserMapper;
import com.tifa.framework.web.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    public void testConnection(){
        System.out.println(userService.selectById(1));
    }

//    测试pageHelper。
    @Test
    public void pageHelperTest(){
        Page<Object> page = PageHelper.startPage(2,3);
        List<User> userList = userService.selectList(null);
        PageInfo<User> pageInfo = new PageInfo<>(userList,3);
        System.out.println(page);
        System.out.println(pageInfo);
    }
}
