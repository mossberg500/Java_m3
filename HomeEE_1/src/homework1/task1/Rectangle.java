package homework1.task1;

import java.lang.annotation.Retention;


public class Rectangle {
    @MyAnnotation(sizeA = 5, sizeB = 43)
    public static int square(int sizeA, int sizeB){
        int s = sizeA * sizeB;
        return s;
    }


}
