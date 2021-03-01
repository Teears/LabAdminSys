package ltd.syskaoqin.springboot.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName ScheduleTask
 * @Description TODO
 * @createTime 2021年03月01日21:47
 */
@Component
public class ScheduleTask {
    @Scheduled(cron="0 0 1 * * ?")
    public void calculateRecord(){
        System.out.println("每天凌晨清算签到状态");
    }
}
