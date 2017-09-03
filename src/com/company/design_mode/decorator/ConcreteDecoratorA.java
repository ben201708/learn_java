package com.company.design_mode.decorator;

public class ConcreteDecoratorA extends Decorator{

    //本类独有的功能，以区别于ConcreteDecoratorB
    private String addadState;

    @Override
    public void Operation(){

        //首先运行原Component的Operation方法，再执行本类新增的功能。相当于对父类进行装饰
        super.Operation();
        addadState = "添加A状态";
        System.out.println("具体装饰对象A的操作");
    }
}
