package com.warrior.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @version v1.0
 * @ProjectName: ETH
 * @ClassName: AsyncTask
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Yanghaha
 * @Date: 2019/12/9 15:59
 */
@Component
public class AsyncTask {
    @Async
    public Future<Boolean> doTask()throws Exception{
        long start=System.currentTimeMillis();
        Thread.sleep(7000);
        long end=System.currentTimeMillis();
        System.out.println("任务耗时："+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }
}
