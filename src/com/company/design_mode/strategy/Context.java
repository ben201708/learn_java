package com.company.design_mode.strategy;

import java.io.Console;

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
