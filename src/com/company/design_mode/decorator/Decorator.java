package com.company.design_mode.decorator;

/**
 * 装饰模式-装饰抽象对象
 */
abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    //重写Operation,实际执行的是Component的Operation()方法
    public void Operation() {
        if (component != null) {
            component.Operation();
        }
    }
}
