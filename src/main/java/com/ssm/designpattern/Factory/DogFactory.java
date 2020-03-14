package com.ssm.designpattern.Factory;

import com.ssm.designpattern.SimpleFactory.Animal;
import com.ssm.designpattern.SimpleFactory.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal create() {
        return new Dog();
    }
}
