import beanwork.auto.AutoBean;
import com.starter.MySchool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@ContextConfiguration(classes = AutoBean.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AutoBeanTest {

    @Autowired
    private AutoBean example;

    @Test
    public void test() {
        example.info();
    }


    @Autowired
    MySchool mySchool;

    @Test
    public void test22() {
        System.out.println(123);
        System.out.println(mySchool.toString());
    }




}
