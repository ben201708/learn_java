package forkJoin;

import java.util.Random;

public class CoinBag {

    private static int coinLen = 40000;
    private static Coin[] coins = new Coin[coinLen];

    public static Coin[] getCoin() {
        for (int i = 0; i < coinLen - 1; i++) {
            Coin coin = new Coin();
            CoinWeight cw = new Random().nextBoolean() ? CoinWeight.LIGHT : CoinWeight.HEVEY;
            coin.setCoinWeight(cw);

            coins[i] = coin;
        }
        return coins;
    }

    public static void main(String[] args) {

        new CoinBag().getCoin();

        for (Coin coin : coins) {
            System.out.println(coin.getCoinWeight());
        }
    }

}
