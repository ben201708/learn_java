package com.designMode.decorator;

/**
 * 装饰模式客户端代码实现
 */
public class DecoratorMain {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA a = new ConcreteDecoratorA();
        ConcreteDecoratorB b = new ConcreteDecoratorB();

        //装饰的方法是：首先用ConcretCompontent实例化对象c，然后用
        //ConcreteDecoratorA的实例化对象a来包装c，再用
        // ConcreteDecoratorB的对象来包装a，最终执行b的Operation方法
        a.setComponent(c);
        b.setComponent(a);
        b.Operation();
    }
}
