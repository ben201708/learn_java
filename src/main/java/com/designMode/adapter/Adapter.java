package com.designMode.adapter;

/**
 * 通过在内部包装一个Adaptee对象，把源接口转换为目标接口
 */
public class Adapter extends Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
