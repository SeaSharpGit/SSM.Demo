package com.ssm.designpattern.Factory;

import com.ssm.designpattern.SimpleFactory.Animal;
import com.ssm.designpattern.SimpleFactory.Cat;

public class CatFactory implements AnimalFactory {
    @Override
    public Animal create() {
        return new Cat();
    }
}
