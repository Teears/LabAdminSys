package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Record;
import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.ListAndMapConvert;
import ltd.syskaoqin.springboot.util.TimeUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentHistory
 * @Description TODO 学生历史记录页面接口
 * @createTime 2021年02月22日20:20
 */
@RestController
@RequestMapping("/stu/history")
public class StudentHistoryController {
    @Resource
    private UserAndLabService userAndLabService;
    @Resource
    private RecordService recordService;

    @GetMapping(value = "/load")
    @ResponseBody
    public Result load(HttpServletRequest request) throws ParseException {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        UserAndLab userAndLab = userAndLabService.selectByStuOpenid(openid);

        int total = TimeUtil.subNowDate(userAndLab.getCreateTime());
        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.add(Calendar.DATE, -60);
        Date startDate = cal.getTime();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");

        Map<String,String> data = new HashMap<>();
        data.put("endDate",sdf.format(endDate));
        data.put("startDate",sdf.format(startDate));
        data.put("total",String.valueOf(total));

        List<Map<String, Integer>> list = recordService.selectOnesStatus(openid);
        Map<String,Integer> map = ListAndMapConvert.convertRecord(list);
        System.out.println(map);

        data.put("finished",String.valueOf(map.get("0")));
        data.put("dayoff",String.valueOf(map.get("4")));
        data.put("absent",String.valueOf(map.get("1")));
        Number num1 = map.get("2");
        int a = num1.intValue();
        Number num2 = map.get("3");
        int b = num2.intValue();
        data.put("late",String.valueOf(a+b));
        Double finishRate = recordService.calculateFinishRate(openid);
        data.put("finishRate",String.format("%.2f", finishRate*100));
        double rank = recordService.calculateSurpass(openid,userAndLab.getLabId());
        double whole = userAndLabService.calculateLabTotal(userAndLab.getLabId());
        if((whole-rank)*100/whole <= 0){
            data.put("surpass","100");
        }else {
            data.put("surpass",String.format("%.2f",(whole-rank)*100/whole));
        }
        return ResultUtils.success(data);
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public Result getDetail(HttpServletRequest request,@RequestParam String year,@RequestParam String month,@RequestParam String day){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        String date = year + "-" +TimeUtil.add0(month)+"-"+TimeUtil.add0(day);
        Record record = recordService.findByOpenidAndDate(openid,date);
        Map<String,String> data = new HashMap<>();
        data.put("checkinTime",record.getCheckinTime());
        data.put("checkinAddress",record.getCheckinLocation());
        data.put("checkoutTime",record.getCheckoutTime());
        data.put("checkoutAddress",record.getCheckoutLocation());
        return ResultUtils.success(data);
    }

    @GetMapping(value = "/daysInfo")
    @ResponseBody
    public Result getDaysInfo(@RequestParam String month,@RequestParam String year,HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        List<Map<String,Integer>> list = recordService.findDaysInfo(TimeUtil.add0(month),year,openid);
        return ResultUtils.success(list);
    }
}
