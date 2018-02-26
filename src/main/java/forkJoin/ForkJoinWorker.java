package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWorker {
    private static class Worker extends RecursiveTask<Integer> {

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
        protected Integer compute() {
            int count = 0;
            if (toIndex - fromIndex < THRESHOLD) {

                for (int i = fromIndex; i < toIndex; i++) {
                    if (balance.weight(bag, i)) {
                        count++;
                    }
                }

            } else {
                int mid = (fromIndex + toIndex) / 2;
                Worker left = new Worker(bag, balance, fromIndex, mid);
                Worker right = new Worker(bag, balance, mid + 1, toIndex);

                //交给forkJoin框架进行处理
                invokeAll(left, right);
                return left.join() + right.join();
            }

            return count;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        Coin[] coins = CoinBag.getCoin();

        IProcess process = new CoinProcess();
        IBalance balance = new CoinBalance(process);

        long start = System.currentTimeMillis();
        Worker worker = new Worker(coins, balance, 0, coins.length - 1);
        pool.invoke(worker);
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
