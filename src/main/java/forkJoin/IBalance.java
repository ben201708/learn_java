package forkJoin;

public interface IBalance {
    //处理袋子中的钱币进行称重
    boolean weight(Coin[] bag, int i);
}
