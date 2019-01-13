package com.linxiaomi.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    /**
     * second(秒) as well as minute(分), hour(时), day of month(天), month(月) and day of week(周几)
     * 0 * * * * MON-FRI
     * [0 0/5 14,18 * * ?] 每天14点整和18点整,每隔5分钟执行一次
     * [0 15 10 ? * 1-6] 每个月的周一至周六10:15执行一次
     * [0 0 2 ? * 6L] 每个月的最后一个周六凌晨两点执行一次
     * [0 0 2 LW * ?] 每个月的最后一个工作日凌晨两点执行一次
     * [0 0 2-4 ? * 1#1] 每个月的第一个周一凌晨两点到4点期间,每个正点都执行一次
     */
//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0/4 * * * * MON-SAT") // 每4秒一次
    public void hello() {
        System.out.println("hello...");
    }
}
