package ltd.syskaoqin.springboot.component;

import ltd.syskaoqin.springboot.dao.entity.Record;
import ltd.syskaoqin.springboot.service.DayOffService;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.util.TimeUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName ScheduleTask
 * @Description TODO 定时任务，清算签到状态
 * @createTime 2021年03月01日21:47
 */
@Component
public class ScheduleTask {
    @Resource
    private RecordService recordService;
    @Resource
    private DayOffService dayOffService;

    @Scheduled(cron="0 0 23 * * ?")
    public void calculateRecord(){
        System.out.println("每天23点清算签到状态");
        String nowDate = TimeUtil.getNowDate();
        //1、查找出已加入实验室但今日没有的签到记录
        List<Record> list = recordService.selectNotCheck(nowDate);
        //2、判断今天是否请假
        for(Record record : list) {
            //3、向其中插入数据openid,labId,checkDate,status（没有请假1缺席，已请假4）
            record.setCheckDate(nowDate);
            if(dayOffService.selectByOpenidAndDate(record.getOpenid(),nowDate) > 0){
                //已请假
                record.setStatus("4");
            }else {
                //未请假缺席
                record.setStatus("1");
            }
            recordService.insertCalculateRecord(record);
        }

    }
}
