package com.designMode.composite;

/**
 * 组合模式：
 * 为组合中的对象申明接口
 * 适当情况下，实现所有类共有接口的默认行为
 * 申明一个接口用于访问和管理Component的子部件
 */
abstract class Component {
    protected String name;
    public Component(String name){
        this.name = name;
    }
    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void display(int depth);
}
