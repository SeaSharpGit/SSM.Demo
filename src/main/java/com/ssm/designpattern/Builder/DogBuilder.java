package com.ssm.designpattern.Builder;


public class DogBuilder {
    Dog dog=new Dog();

    public DogBuilder age(int age){
        dog.setAge(age);
        return this;
    }

    public DogBuilder name(String name){
        dog.setName(name);
        return this;
    }

    public Dog bulid(){
        return dog;
    }
}
