package src.nix.ry.rudenko;

import src.nix.ry.rudenko.rOffice.RyExel;
import src.nix.ry.rudenko.generators.GeneratorRandom;

import MyLibs.MyLibForUnit2Compile;
public class Main {
    public static void main(String[] args) {
        System.out.println("Manual compile!!!");
        System.out.println("_________________________");
        System.out.println("my library - MyLibForUnit2Compile.jar do it: ");
        MyLibForUnit2Compile myLibForUnit2Compile = new MyLibForUnit2Compile();
        System.out.println(myLibForUnit2Compile.hello());
        System.out.println("_________________________");
        System.out.println("apache library - poi-5.0.0.jar do it: ");
        RyExel sx = new RyExel();
        sx.CreateExel();
        System.out.println("_________________________");
        System.out.println("apache library - commons-math3-3.6.1.jar do it: ");
        GeneratorRandom generatorRandom = new GeneratorRandom();
        generatorRandom.myMethod();
        System.out.println("_________________________");
    }
}
