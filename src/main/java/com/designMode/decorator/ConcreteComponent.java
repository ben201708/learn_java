package com.designMode.decorator;

/**
 * 装饰模式-具体的装饰对象
 * 可给这个对象添加职责
 */
public class ConcreteComponent extends Component {
    @Override
    public void Operation() {
        System.out.println("具体对象的操作");
    }
}
