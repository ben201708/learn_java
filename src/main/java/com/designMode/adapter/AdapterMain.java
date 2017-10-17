package com.designMode.adapter;

/**
 * 适配器模式客户端实现代码
 */
public class AdapterMain {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
