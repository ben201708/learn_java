package com.designMode.flyweight;

/**
 * 所有具有享元类的超类或接口
 * 通过这个接口，Flyweight可以接收并作用于外部状态
 */
abstract class Flyweight {
    public abstract void Operation(int extrinsicstate);
}
