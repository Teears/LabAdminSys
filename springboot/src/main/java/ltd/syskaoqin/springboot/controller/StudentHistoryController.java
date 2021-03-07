package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.TimeUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.sql.Time;
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
        UserAndLab userAndLab = userAndLabService.selectByOpenid(openid);

        int total = TimeUtil.subNowDate(userAndLab.getCreateTime());
        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.add(Calendar.DATE, -60);
        Date startDate = cal.getTime();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");

        Map<String,String> data = new HashMap<>();
        data.put("endDate",sdf.format(endDate));
        data.put("startDate",sdf.format(startDate));
        data.put("total",String.valueOf(total));

        Map<Integer,Integer> map = recordService.selectOnesStatus(openid);
        data.put("finished",String.valueOf(map.get(0)));
        data.put("dayoff",String.valueOf(map.get(4)));
        data.put("absent",String.valueOf(map.get(1)));
        data.put("late",String.valueOf(map.get(2)+map.get(3)));
        Double finishRate = recordService.calculateFinishRate(openid);
        data.put("finishRate",String.format("%.2f", finishRate*100));
        double rank = recordService.calculateSurpass(openid,userAndLab.getLabId());
        double whole = userAndLabService.calculateLabTotal(userAndLab.getLabId());
        data.put("surpass",String.format("%.2f",(whole-rank)/whole));

        return ResultUtils.success(data);
    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public Result getDetail(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);

        return ResultUtils.success();
    }

    @GetMapping(value = "/daysInfo")
    @ResponseBody
    public Result getDaysInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);

        return ResultUtils.success();
    }
}
