package com.company.design_mode.factory;

/**
 * 工厂模式
 */
public class OperationFactory {

    public static Operation create(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
        }
        return oper;
    }
}
