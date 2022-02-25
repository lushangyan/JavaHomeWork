import com.beanwork.xml.XmlExample;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlExampleTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");
        XmlExample example = (XmlExample) context.getBean("XmlExample");
        example.info();
    }
}
