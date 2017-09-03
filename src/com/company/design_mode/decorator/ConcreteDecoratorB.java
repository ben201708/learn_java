package com.company.design_mode.decorator;

public class ConcreteDecoratorB extends Decorator{

    @Override
    public void Operation(){

        //首先运行原Component的Operation方法，再执行本类新增的功能。相当于对父类进行装饰
        super.Operation();
        addadBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    //本类特有方法
    public void addadBehavior(){

    }
}
