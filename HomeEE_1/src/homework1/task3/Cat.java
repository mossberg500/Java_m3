package homework1.task3;

import sun.security.x509.UniqueIdentity;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Cat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Save
    private  String name;
    private String eyes;
    @Save
    private int age;
    private double mass;

    public Cat(String name, String eyes, int age, double mass) {
        this.name = name;
        this.eyes = eyes;
        this.age = age;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }


    public static void serizable(Cat cat, String path) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path))) {
            List<Object> annotatedFields = new ArrayList<>();
            Class clazz = cat.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Save.class)) {
                    Object fieldValue = f.get(cat);
                    annotatedFields.add(fieldValue);
                }
            }
            writer.writeObject(annotatedFields);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<Object> deserizable(String path) {
        List<Object> fields = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {
            fields = (List<Object>) reader.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return fields;
    }





    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", eyes='" + eyes + '\'' +
                ", age=" + age +
                ", mass=" + mass +
                '}';
    }
}
