package com.company.design_mode.factory;

/**
 * 工厂模式客户端代码实现
 */
public class FactoryMain {
    public static void main(String[] args) {

        //简单工厂模式
        Operation oper;
        oper = OperationFactory.create("+");
        oper.setA(1);
        oper.setB(2);
        double res = oper.getRes();
        System.out.println(res);

        //工厂方法模式
        Operation operation = new OperationAdd();
        operation.setA(4);
        operation.setB(2);
        double res2 = operation.getRes();
        System.out.println(res2);
    }
}
