package forkJoin;

public class CoinBalance implements IBalance {

    public CoinBalance(IProcess process) {
    }

    @Override
    public boolean weight(Coin[] bag, int i) {
        if (bag[i].getCoinWeight().equals(CoinWeight.LIGHT)) {
            return true;
        }
        return false;
    }
}
