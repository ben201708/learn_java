package com.company.design_mode.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 组合模式：定义有分支节点行为，用来存储子部件，在Component接口中实现与子部件有关的操作
 */
public class Composite extends Component {

    private List<Component> child = Collections.synchronizedList(new ArrayList());

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        child.add(c);
    }

    @Override
    public void remove(Component c) {
        child.remove(c);
    }

    @Override
    public void display(int depth) {
        String str = new String();
        for (int i = 0; i < depth; i++) {
            str += "-";
        }
        System.out.println(str + name);

        for (Component component : child) {
            component.display(depth + 2);
        }
    }
}
