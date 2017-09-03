package com.company.design_mode.factory;

public class OperationSub extends Operation {
    
    public double getRes() {
        double res = 0;
        res = super.getA() - super.getB();
        return res;
    }
}
