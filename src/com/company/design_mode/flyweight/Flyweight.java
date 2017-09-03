package com.company.design_mode.flyweight;

/**
 * 所有具有向元磊的超类或接口
 * 通过这个接口，Flyweight可以接收并作用于外部状态
 */
abstract class Flyweight {
    public abstract void Operation(int extrinsicstate);
}
