package src.nix.ry.rudenko.generators;

import  org.apache.commons.math3.random.RandomDataGenerator;

public class GeneratorRandom {

    public void myMethod() {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        System.out.println("Our random number is " + randomDataGenerator.nextInt(1, 100));
        System.out.println("random number generated");
    }
}