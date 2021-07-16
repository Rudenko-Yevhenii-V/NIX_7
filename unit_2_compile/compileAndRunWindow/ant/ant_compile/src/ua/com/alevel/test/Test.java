package ua.com.alevel.test;

import  org.apache.commons.math3.random.RandomDataGenerator;
import MyLibs.MyLibForUnit2Compile;

public class Test {

    public void run() {
        System.out.println("Ant compile!!!");
        System.out.println("_________________________");
        //myLib MyLibForUnit2Compile.jar
        System.out.println("my library - MyLibForUnit2Compile.jar do it: ");
        MyLibForUnit2Compile myLibForUnit2Compile = new MyLibForUnit2Compile();
        System.out.println(myLibForUnit2Compile.hello());
        System.out.println("_________________________");

        //lib commons-math3-3.6.1.jar
        System.out.println("apache library - commons-math3-3.6.1.jar do it: ");
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        System.out.println("Our random number is " + randomDataGenerator.nextInt(1, 100));
        System.out.println("random number generated");
        System.out.println("_________________________");
    }
}