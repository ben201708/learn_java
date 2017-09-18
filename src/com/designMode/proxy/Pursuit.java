package com.designMode.proxy;

/**
 * 追求者去实现送礼物的接口
 */
class Pursuit implements GiveGift{
    SchoolGirl mm;

    public Pursuit(SchoolGirl mm){
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println("送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println("送你花");
    }

    @Override
    public void giveChocolate() {
        System.out.println("送你巧克力");
    }
}
