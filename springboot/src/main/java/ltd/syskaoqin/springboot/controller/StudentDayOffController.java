package ltd.syskaoqin.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ltd.syskaoqin.springboot.dao.entity.DayOff;
import ltd.syskaoqin.springboot.service.DayOffService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName StudentDayOffController
 * @Description TODO 学生请假相关接口
 * @createTime 2021年03月21日13:48
 */
@RestController
@RequestMapping("/stu/dayOff")
public class StudentDayOffController {
    @Resource
    DayOffService dayOffService;

    @PostMapping(value = "/addDayOff")
    @ResponseBody
    public Result checkin(@RequestParam Map<String, String> param, HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        String type = param.get("dayoffType");
        String day = param.get("day");
        String phone = param.get("phone");
        String desc = param.get("desc");
        System.out.println(param);
        DayOff dayOff = new DayOff();
        dayOff.setOpenid(openid);
        dayOff.setType(type);
        dayOff.setContact(phone);
        dayOff.setReason(desc);
        dayOff.setDayOffTime(day);
        try {
            dayOffService.insertDayOff(dayOff);
        }catch (DuplicateKeyException e){
            System.out.println("重复请假");
        }
        return ResultUtils.success();
    }

    @GetMapping(value = "/dayOffList")
    @ResponseBody
    public Result getDaysInfo(HttpServletRequest request,int currentPage,int pageSize){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Map<String,Object> data = new HashMap<>();

        PageHelper.startPage(currentPage, pageSize);
        List<DayOff> dayOffList = dayOffService.selectFormatDayOffList(openid);
        PageInfo<DayOff> info = new PageInfo<>(dayOffList);

        List<DayOff> list = info.getList();
        List<JSONObject> jsonList = new ArrayList<>();
        for(DayOff dayOff: list){
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonTitle = new JSONObject();
            jsonObject.put("tag",dayOff.getIsPass());
            jsonObject.put("applyTime",dayOff.getApplyTime());
            jsonObject.put("content",dayOff.getReason());
            jsonTitle.put("type",dayOff.getType());
            String str = dayOff.getDayOffTime();
            String[] strList = str.split(",");
            for(int i = 0;i<strList.length;i++){
                strList[i] = strList[i].substring(5);
            }
            jsonTitle.put("days",strList);
            jsonObject.put("title",jsonTitle);
            jsonList.add(jsonObject);
        }

        data.put("list",jsonList);
        data.put("isLastPage",info.isIsLastPage());
        return ResultUtils.success(data);
    }
}
