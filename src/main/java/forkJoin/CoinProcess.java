package forkJoin;

public class CoinProcess implements IProcess {
    @Override
    public void process(Coin coin) {
        recycle();
    }

    //假币回收方法
    private void recycle() {
        try {
            Thread.sleep(1);
            System.out.println("假币回收，thread:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
