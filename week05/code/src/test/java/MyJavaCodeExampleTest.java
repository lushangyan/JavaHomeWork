import beanwork.javacode.MyJavaCodeConfig;
import beanwork.javacode.MyJavaCodeExample;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyJavaCodeExampleTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(MyJavaCodeConfig.class);
        MyJavaCodeExample example = (MyJavaCodeExample) configApplicationContext.getBean("javaCodeExample");
        example.info();
    }
}
