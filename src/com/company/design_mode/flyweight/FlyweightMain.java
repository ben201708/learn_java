package com.company.design_mode.flyweight;

/**
 * 享元模式客户端代码
 */
public class FlyweightMain {

    public static void main(String[] args) {
        int extrinstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.Operation(--extrinstate);

        Flyweight fy = f.getFlyweight("Y");
        fy.Operation(--extrinstate);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
        uf.Operation(--extrinstate);
    }
}
