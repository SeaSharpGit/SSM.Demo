package com.ssm.designpattern.Builder;

public class BuildDemo {
    public static void main(){
        Dog dog=new DogBuilder().age(1).name("Jack").bulid();
    }
}
