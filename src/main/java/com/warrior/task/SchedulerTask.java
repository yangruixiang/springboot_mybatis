package com.warrior.task;

import io.lettuce.core.dynamic.annotation.Command;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version v1.0
 * @ProjectName: ETH
 * @ClassName: SchedulerTask
 * @Description: TODO(测试定时器)
 * @Author: Yanghaha
 * @Date: 2019/12/9 15:46
 */
@Component
public class SchedulerTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
//    @Scheduled(cron="*/6 * * * * ?")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
