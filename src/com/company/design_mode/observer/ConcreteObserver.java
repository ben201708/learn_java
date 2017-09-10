package com.company.design_mode.observer;

/**
 * 具体观察者，实现抽象观察者角色要求的接口
 */
public class ConcreteObserver extends Observer {

    private String name;
    private String observerState;
    private ConcreteSubject subjct;

    public ConcreteObserver(ConcreteSubject subjct, String name) {
        this.subjct = subjct;
        this.name = name;
    }

    @Override
    public void update() {
        observerState = subjct.getSubjectState();
        System.out.println("观察者0的新状态是1" + name + observerState);
    }

    public ConcreteSubject getSubjct() {
        return subjct;
    }

    public void setSubjct(ConcreteSubject subjct) {
        this.subjct = subjct;
    }
}
