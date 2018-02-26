package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinWorker2 {
    //并行处理
    private static class Worker extends RecursiveAction {

        private static final long serialVersionUID = 1L;

        //任务拆分阀值
        private static final long THRESHOLD = 2000;

        //硬币口袋
        private Coin[] bag;

        //判断硬币真假的接口
        private IBalance balance;

        //任务拆分开始
        private int fromIndex;

        //任务拆分结束
        private int toIndex;

        public Worker(Coin[] bag, IBalance balance, int fromIndex, int toIndex) {
            super();
            this.bag = bag;
            this.balance = balance;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected void compute() {
            int count = 0;
            if (toIndex - fromIndex < THRESHOLD) {
                for (int i = fromIndex; i < toIndex; i++) {
                    if (balance.weight(bag, i)) {
                        count++;
                    }
                    //System.out.println("当前bag信息：" + i);
                }
            } else {

                int mid = (fromIndex + toIndex) / 2;
                Worker left = new Worker(bag, balance, fromIndex, mid);
                Worker right = new Worker(bag, balance, mid + 1, toIndex);

                System.out.println("当前bag：11");

                //交给forkJoin框架进行处理
                invokeAll(left, right);
                return;
            }

            return;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        Coin[] coins = CoinBag.getCoin();

        IProcess process = new CoinProcess();
        IBalance balance = new CoinBalance(process);

        long start = System.currentTimeMillis();
        Worker worker = new Worker(coins, balance, 0, coins.length - 1);
        pool.execute(worker);
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start));

        //while (!pool.isShutdown()) {
        //showLog(pool);
        //}
    }

    private static void showLog(ForkJoinPool pool) {
        System.out.println("线程偷取的任务数:" + pool.getStealCount());
        System.out.println("线程池是否终止:" + pool.isShutdown());
    }
}
