package ltd.syskaoqin.springboot.controller;


import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.service.UserService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.ListAndMapConvert;
import ltd.syskaoqin.springboot.util.TimeUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName BindRole
 * @Description TODO 教师管理页面接口
 * @createTime 2021年02月22日20:22
 */
@RestController
@RequestMapping("/tea/manage")
public class TeacherManageController {

    @Resource
    private LabService labService;
    @Resource
    private RecordService recordService;
    @Resource
    private UserService userService;

    @GetMapping(value = "/managelist")
    @ResponseBody
    public Result totalManageList(HttpServletRequest request) {
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
    public Result setLab(@RequestParam Map<String, String> param, HttpServletRequest request){
        String labId = param.get("labId");
        String checkinTime1 = param.get("checkinTime1");
        String checkinTime2 = param.get("checkinTime2");
        String checkoutTime1 = param.get("checkoutTime1");
        String checkoutTime2 = param.get("checkoutTime2");
        labService.updateCheckTime(labId,checkinTime1,checkinTime2,checkoutTime1,checkoutTime2);

        return ResultUtils.success();
    }

    @PostMapping(value = "/editlab")
    @ResponseBody
    public Result editLab(@RequestParam("file") MultipartFile file, @RequestParam Map<String, String> param, HttpServletRequest request) throws IOException {
        String labId = param.get("labId");
        String desc = param.get("desc");
        String rule = param.get("rule");
        String filePath="D:/GP/img/";
        String originalFilename = file.getOriginalFilename();
        String suf = originalFilename.substring(file.getOriginalFilename().indexOf(".") + 1);
        String newFileName= labId + "-" + UUID.randomUUID() +"."+ suf;
        // 封装上传文件位置的全路径
        File targetFile  = new File(filePath,newFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        labService.updateLabInfo(labId,desc,rule,filePath+newFileName);
        System.out.println(targetFile);
        return ResultUtils.success();
    }

    @GetMapping(value = "/getCheckinList")
    @ResponseBody
    public Result getCheckinList(@RequestParam String labId,@RequestParam String checkDate){
        List<Map<String,Integer>> list = recordService.getCheckList(labId,checkDate);
        System.out.println(list);
        return ResultUtils.success(list);
    }

    @GetMapping(value = "/getStatisticList")
    @ResponseBody
    public Result getStatisticList(@RequestParam String labId){
        List<String> openidList = labService.findStuListInLab(labId);
        List<Map<String,String>> datas = new ArrayList<>();
        for(String openid: openidList){
            Map<String,String> data = new HashMap<>();
            List<Map<String, Integer>> list = recordService.selectOnesStatus(openid);
            Map<String,Integer> map = ListAndMapConvert.convertRecord(list);

            int tag0 = 0;
            int tag1 = 0;
            int tag2 = 0;
            int tag3 = 0;
            int tag4 = 0;
            if( map.get("0")!=null){
                Number tmp = map.get("0");
                tag0 = tmp.intValue();
            }
            if( map.get("1")!=null){
                Number tmp = map.get("1");
                tag1 = tmp.intValue();
            }
            if( map.get("2")!=null){
                Number tmp = map.get("2");
                tag2 = tmp.intValue();
            }
            if( map.get("3")!=null){
                Number tmp = map.get("3");
                tag3 = tmp.intValue();
            }
            if( map.get("4")!=null){
                Number tmp = map.get("4");
                tag4 = tmp.intValue();
            }

            data.put("finished",String.valueOf(tag0));
            data.put("dayoff",String.valueOf(tag4));
            data.put("absent",String.valueOf(tag1));
            data.put("late",String.valueOf(tag2+tag3));
            Double finishRate = recordService.calculateFinishRate(openid);
            if(finishRate == null){
                finishRate = 0.0;
            }
            data.put("finishRate",String.format("%.1f", finishRate*100));
            Map<String,String> basicInfo = userService.findAvatarName(openid);
            data.put("avatarUrl",basicInfo.get("avatarUrl"));
            data.put("name",basicInfo.get("name"));
            datas.add(data);
        }
        return ResultUtils.success(datas);
    }

}
