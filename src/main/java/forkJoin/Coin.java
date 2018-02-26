package forkJoin;

public class Coin {
    private CoinWeight coinWeight;

    public CoinWeight getCoinWeight() {
        return coinWeight;
    }

    public void setCoinWeight(CoinWeight coinWeight) {
        this.coinWeight = coinWeight;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinWeight=" + coinWeight +
                '}';
    }
}
