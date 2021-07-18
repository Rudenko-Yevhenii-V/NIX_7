package src.nix.ry.rudenko;

import src.nix.ry.rudenko.rOffice.RyExel;
import src.nix.ry.rudenko.generators.GeneratorRandom;
public class Main {
    public static void main(String[] args) {
        System.out.println("Maven compile!!!");
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
