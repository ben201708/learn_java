package com.designMode.factory;

public class OperationAdd extends Operation {

    public double getRes() {
        double res = 0;
        res = super.getA() + super.getB();
        return res;
    }
}
