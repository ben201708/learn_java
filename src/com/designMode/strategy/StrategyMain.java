package com.designMode.strategy;

/**
 * 策略模式客户端执行
 */
public class StrategyMain {
    public static void main(String[] args) {
        Context context;

        //执行策略A算法
        context = new Context(new ConcreteStrategyA());
        context.ContextInterface();

        //执行策略B算法
        context = new Context(new ConcreteStrategyB());
        context.ContextInterface();
    }
}
