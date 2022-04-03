import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

/**
 * redis相关测试。
 */
@SpringBootTest
public class redisTest {
    @Test
    public void connectTest(){
        Jedis jedis = new Jedis("120.53.121.245",6379);
        String value = jedis.ping();
        System.out.println(value);
        System.out.println(jedis.keys("*"));
    }
}
