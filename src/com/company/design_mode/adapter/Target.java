package com.company.design_mode.adapter;

/**
 * 客户所期待的接口
 * 目标可以是具体的或者抽象的类，也可以是接口
 */
public class Target {
    public void request() {
        System.out.println("普通请求");
    }
}
