package com.company.design_mode.proxy;

public class ProxyMain {

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("jane");
        Proxy proxy = new Proxy(schoolGirl);

        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();
    }


}
