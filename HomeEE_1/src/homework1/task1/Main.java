package homework1.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = Rectangle.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods){
            if (m.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
                int res = (Integer)m.invoke(null, myAnnotation.sizeA(), myAnnotation.sizeB());
                System.out.println(res);
            }
        }
    }
}
