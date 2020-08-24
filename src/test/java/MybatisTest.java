import com.synthesize.test.mybatis.MybatisStart;
import com.synthesize.test.mybatis.demo.T1;
import com.synthesize.test.mybatis.mapper.T1Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = MybatisStart.class)
@RunWith(SpringRunner.class)
public class MybatisTest {
    @Autowired
    T1Mapper t1Mapper;
    @Test
    public void sqlIntercept(){
        T1 demo = new T1();
        demo.setName("t1");
        demo.setTime(new Date());
        t1Mapper.insert(demo);
    }
}
