package com.company.design_mode.flyweight;

/**
 * 不需要共享的Flyweight子类
 */
public class UnsharedConcreteFlyweight extends Flyweight {

    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight：" + extrinsicstate);
    }
}
