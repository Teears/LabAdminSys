package ltd.syskaoqin.springboot.controller;


import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.TimeUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tea/")
public class TeacherManageController {

    @Resource
    private LabService labService;
    @Resource
    private RecordService recordService;

    @GetMapping(value = "/managelist")
    @ResponseBody
    public Result totalManageList(HttpServletRequest request) throws ParseException {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        List<Lab> labList = labService.findLabByTeaOpenid(openid);
        List<Map<String,String>> data = new ArrayList<>();
        for(Lab lab: labList){
            Map<String,String> checkInfo = new HashMap<>();
            Map<String,Integer> checkCount = recordService.checkinCheckoutBoth(lab.getId(),TimeUtil.getNowDate());
            int total = labService.countStuInLab(lab.getId());
            Number both = checkCount.get("checkboth");
            int checkBoth = both.intValue();

            checkInfo.put("checkin",lab.getCheckinStart().substring(0,5)+
                    '~'+lab.getCheckinEnd().substring(0,5));
            checkInfo.put("checkout",lab.getCheckoutStart().substring(0,5)+
                    '~'+lab.getCheckoutEnd().substring(0,5));
            checkInfo.put("labId",lab.getId());
            checkInfo.put("labNum",lab.getLabNumber());
            checkInfo.put("rate",String.valueOf(100*checkBoth/total));
            checkInfo.put("total",String.valueOf(total));
            checkInfo.put("check",String.valueOf(checkCount.get("checkin")));
            checkInfo.put("checkOut",String.valueOf(checkCount.get("checkout")));
            data.add(checkInfo);
        }
        return ResultUtils.success(data);
    }

    @PostMapping(value = "/setlab")
    @ResponseBody
    public Result bindIdStu(@RequestParam Map<String, String> param, HttpServletRequest request){
        String labId = param.get("labId");
        String checkinTime1 = param.get("checkinTime1");
        String checkinTime2 = param.get("checkinTime2");
        String checkoutTime1 = param.get("checkoutTime1");
        String checkoutTime2 = param.get("checkoutTime2");
        labService.updateCheckTime(labId,checkinTime1,checkinTime2,checkoutTime1,checkoutTime2);

        return ResultUtils.success();
    }
}
