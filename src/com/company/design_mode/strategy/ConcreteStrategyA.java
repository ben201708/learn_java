package com.company.design_mode.strategy;

import java.io.Console;

/**
 * 策略模式具体算法A
 */
public class ConcreteStrategyA extends Strategy{

    @Override
    public void algoriyhmInterface() {
        System.out.println("算法A实现");
    }
}
