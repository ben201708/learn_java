package com.future;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Future;

public class TestFuture {

    @Test
    public void test(){
        /**
        // 并行获取用户会员引导和基础卡号
        final Future<?> vipGuideFuture = ;
        final Future<?> userCardFuture = cardNoLogic.getUserCardNoFromBaseAsync(uid);

        Map<Future<?>, RpcResult> result = FutureSyncUtil.getFuturesResult(
                new HashSet<Future<?>>() {
                    {
                        add(vipGuideFuture);
                        add(userCardFuture);
                    }
                }, 1000);

        // 获取用户引导配制
        Map<String, Object> userGuide = profileCgiLogic.getDefaultLekaGuide();
        RpcResult guideResult = result.get(vipGuideFuture);
         */
    }

    /**
     * 异步获取基础侧获取用户卡号
     *
     * @param uid
     * @return
     */
    public Future<?> getUserCardNoFromBaseAsync(Integer uid) {
        uid = 11232;
        //return FutureSyncUtil.getRpcFuture();
        return null;
    }
}
