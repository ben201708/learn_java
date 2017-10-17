package com.designMode.flyweight;

/**
 * 继承Flyweight，为内部状态增加存储空间
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("具体Flyweight：" + extrinsicstate);
    }
}
