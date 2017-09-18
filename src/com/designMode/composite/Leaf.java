package com.designMode.composite;

/**
 * 组合中叶节点的对象，叶节点没有子节点
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("不能添加到叶子");
    }

    @Override
    public void remove(Component c) {
        System.out.println("无法从叶子删除");
    }

    @Override
    public void display(int depth) {

        String str = new String();
        for (int i = 0; i < depth; i++) {
            str += "-";
        }
        System.out.println(str + name);
    }
}
