package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.entity.Record;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.TimeUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentCheck
 * @Description TODO 学生签到页面接口，包括初始化界面，签到，签退。
 * @createTime 2021年02月22日20:20
 */
@RestController
@RequestMapping("/stu/check")
public class StudentCheckController {
    @Resource
    private LabService labService;
    @Resource
    private RecordService recordService;

    @PostMapping(value = "/checkin")
    @ResponseBody
    public Result checkin(@RequestParam Map<String, String> param, HttpServletRequest request){
        String address = param.get("address");
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        String labId = labService.findLabByStuOpenid(openid).getId();
        String nowTime = TimeUtil.getNowTime();
        String nowDate = TimeUtil.getNowDate();
        Record record = new Record();
        record.setOpenid(openid);
        record.setLabId(labId);
        record.setCheckinLocation(address);
        record.setCheckinTime(nowTime);
        record.setCheckDate(nowDate);
        int rank = recordService.selectRecordCountByLabIdAndCheckDate(labId,nowDate);
        Map<String,String> data = new HashMap<>();
        if(recordService.insertRecord(record) > 0){
            data.put("rank",String.valueOf(rank+1));
        }
        return ResultUtils.success(data);
    }

    @PostMapping(value = "/checkout")
    @ResponseBody
    public Result checkout(@RequestParam Map<String, String> param, HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        String address = param.get("address");
        String nowTime = TimeUtil.getNowTime();
        String nowDate = TimeUtil.getNowDate();
        if(recordService.findByOpenidAndDate(openid,nowDate) != null){
            recordService.updateRecordCheckout(openid,nowDate,nowTime,address);
        }else {
            Record record = new Record();
            String labId = labService.findLabByStuOpenid(openid).getId();
            record.setOpenid(openid);
            record.setLabId(labId);
            record.setCheckDate(nowDate);
            record.setCheckoutLocation(address);
            record.setCheckoutTime(nowTime);
            recordService.insertRecord(record);
        }
        return ResultUtils.success();
    }

    @GetMapping(value = "/load")
    @ResponseBody
    public Result load(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Lab lab = labService.findLabByStuOpenid(openid);
        Map<String,String> data = new HashMap<>();
        if(lab == null){
            data.put("checkinORout","-1");
            data.put("queshengMark","1");
            data.put("msg","你尚未加入任何实验室");
            return ResultUtils.success(data);
        }
        String nowTime = TimeUtil.getNowTime();
        String nowDate = TimeUtil.getNowDate();
        Record record = recordService.findByOpenidAndDate(openid,nowDate);

        if(TimeUtil.isTimeRange(nowTime,"00:00:00",lab.getCheckinStart())){
            //签到尚未开始
            data.put("checkinORout","-1");
            data.put("queshengMark","1");
            data.put("msg","签到尚未开始");
        }else if(TimeUtil.isTimeRange(nowTime,lab.getCheckinStart(),lab.getCheckinEnd())){
            //签到时间内
            if(record == null){
                data.put("checkinORout","1");
                data.put("queshengMark","0");
                data.put("turn_in","0");
            }else {
                data.put("checkinORout","1");
                data.put("queshengMark","0");
                data.put("turn_in","1");
            }
        }else if(TimeUtil.isTimeRange(nowTime,lab.getCheckinEnd(),lab.getCheckoutStart())){
            //签到完成
            if(record == null){
                data.put("checkinORout","-1");
                data.put("queshengMark","1");
                data.put("msg","您已错过签到");
            }else {
                data.put("checkinORout","1");
                data.put("queshengMark","0");
                data.put("turn_in","1");
            }
        }else if(TimeUtil.isTimeRange(nowTime,lab.getCheckoutStart(),lab.getCheckoutEnd())){
            //签退时间内
            if(record == null || record.getCheckoutTime() == null){
                data.put("checkinORout","0");
                data.put("queshengMark","0");
                data.put("turn_out","0");
            }else {
                data.put("checkinORout","0");
                data.put("queshengMark","0");
                data.put("turn_out","1");
            }
        }else {
            //签退完成时间内
            data.put("queshengMark","1");
            data.put("msg","辛苦了一天，休息一下吧！");
        }

        System.out.println(data);
        return ResultUtils.success(data);
    }

}
