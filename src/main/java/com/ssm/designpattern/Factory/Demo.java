package com.ssm.designpattern.Factory;

import com.ssm.designpattern.SimpleFactory.Animal;

public class Demo {
    public void Test(){
        AnimalFactory factory=new DogFactory();
        Animal dog=factory.create();
        dog.eat();
    }
}
