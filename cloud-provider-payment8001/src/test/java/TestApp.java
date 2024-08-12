import com.sapiece.entities.Pay;
import com.sapiece.mapper.PayMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author SAPiece
 * @Create 2024-07-18 10:26
 * @Package PACKAGE_NAME
 * @Project SpringCloud2024
 * @Filename TestApp
 * @Version 1.0
 */
@SpringBootTest
public class TestApp {
    @Resource
    PayMapper payMapper;
    @Test
    void test(){
        List<Pay> pays = payMapper.selectList(null);
        pays.forEach(System.out::println);
    }
}
