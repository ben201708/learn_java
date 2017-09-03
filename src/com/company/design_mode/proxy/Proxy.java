package com.company.design_mode.proxy;

/**
 * 由代理去实现送礼物的接口
 */
public class Proxy implements GiveGift{

    Pursuit gg;

    public Proxy(SchoolGirl mm){
        gg = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
