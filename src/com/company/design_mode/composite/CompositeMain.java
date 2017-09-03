package com.company.design_mode.composite;

/**
 * 组合模式客户端实现
 */
public class CompositeMain {
    public static void main(String[] args) {

        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));
        root.add(comp);

        root.display(1);
    }
}
