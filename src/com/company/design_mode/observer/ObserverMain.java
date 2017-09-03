package com.company.design_mode.observer;

public class ObserverMain {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();

        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));

        s.setSubjectState("ABC");
        s.Notify();

        System.out.println("通知状态变更");
    }
}
