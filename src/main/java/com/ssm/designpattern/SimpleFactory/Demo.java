package com.ssm.designpattern.SimpleFactory;

public class Demo {
    public Animal create(AnimalEnum animalEnum){
        switch (animalEnum){
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            default:
                return null;
        }
    }
}
