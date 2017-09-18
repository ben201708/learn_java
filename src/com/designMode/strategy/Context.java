package com.designMode.strategy;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //实现策略方法
    public void ContextInterface() {
        strategy.algoriyhmInterface();
    }
}
