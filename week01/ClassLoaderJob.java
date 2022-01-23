
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ClassLoaderJob extends ClassLoader{

    public static void main(String[] args) {
        try {
            Object hello = new ClassLoaderJob().findClass("Hello").newInstance();
            Class<?> aClass = hello.getClass();
            Method hello1 = aClass.getMethod("hello");
            hello1.invoke(aClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File("D:\\Develop\\IdeaProjects\\jvm01\\src\\homework\\Hello.xlass");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            fileInputStream.read(buffer,0, (int) file.length());
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = (byte) (255-buffer[i]);
            }
            return defineClass(name,buffer,0,buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }






}
