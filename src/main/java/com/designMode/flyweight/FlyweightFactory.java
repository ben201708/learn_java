package com.designMode.flyweight;

import java.util.Hashtable;

/**
 * 享元工厂，创建并管理享元对象
 * 主要用来确保合理地共享Flyweight，当用户请求一个Flyweight时，FlyweightFactory对象提供一个已创建的实例或创建一个
 */
public class FlyweightFactory {
    private Hashtable flyweights = new Hashtable<String, ConcreteFlyweight>();

    public FlyweightFactory() {
        flyweights.put("X", new ConcreteFlyweight());
        flyweights.put("Y", new ConcreteFlyweight());
        flyweights.put("Z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        return (Flyweight) flyweights.get(key);
    }
}
