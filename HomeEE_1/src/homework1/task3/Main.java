package homework1.task3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat("Vaska","green", 3, 6);
        Cat catTwo = new Cat("Umka","blue", 1, 3);
        Cat catThree = new Cat("Kuzia", "yello",5, 5);
        Cat catFour = new Cat("Markiz", "green",2, 7);
        Cat catFive = new Cat("Dimka", "green",4, 4);

        Cat[] catArray = new Cat[]{catOne, catTwo, catThree, catFour, catFive};

        for (Cat cat : catArray) {
            System.out.println(cat);
        }
        System.out.println("-----------------------");
        String path = "folderProject\\Cat.txt";
        Cat.serizable(catThree, path);
        List<Object> list = Cat.deserizable(path);
        list.forEach(l->System.out.println(l));

    }
}