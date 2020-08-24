import com.synthesize.UtilStart;
import com.synthesize.test.annotation.qualifier.demo.One;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UtilStart.class)
@RunWith(SpringRunner.class)
public class QualifierTest {
    @Autowired
    @Qualifier("t1")
    One t1;
    @Autowired
    @Qualifier("t2")
    One t2;
    @Test
    public void qualifier(){
        System.out.println(t1.getOne());
        System.out.println(t2.getOne());
    }
}
