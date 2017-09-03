package com.company.design_mode.flyweight;

/**
 * 继承Flyweight，为内部状态增加存储空间
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("具体Flyweight：" + extrinsicstate);
    }
}
