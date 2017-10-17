package com.designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 主题或者抽象统治者，一般是一个抽象类或者一个接口实现
 */
abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    //增加观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //移除观察者
    public void detaach(Observer observer) {
        observers.remove(observer);
    }

    //通知
    public void Notify() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
