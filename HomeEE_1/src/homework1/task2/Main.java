package homework1.task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
      Class<?> textContainer = TextContainer.class;
      SaveToFile saveToFile = textContainer.getAnnotation(SaveToFile.class);
        String uFile = saveToFile.str();

        Method[] methods = textContainer.getDeclaredMethods();
        for (Method method : methods){
            if(method.isAnnotationPresent(Saver.class)){
                method.invoke(textContainer.newInstance(), uFile);
            }
        }
    }
}
