package ltd.syskaoqin.springboot.controller;


import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.RecordService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.TimeUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

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

        System.out.println(file);
        System.out.println(param);
        System.out.println(request);
        return ResultUtils.success();
    }

//    CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
//            request.getSession().getServletContext());
//        if(multipartResolver.isMultipart(request))
//    {
//        //将request变成多部分request
//        MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
//        //获取multiRequest 中所有的文件名
//        Iterator iter=multiRequest.getFileNames();
//        while(iter.hasNext())
//        {
//            //一次遍历所有文件
//            MultipartFile file=multiRequest.getFile(iter.next().toString());
//            if(file!=null)
//            {
//                String path="D:/GP/img"+file.getOriginalFilename();
//                //上传
//                file.transferTo(new File(path));
//                System.out.println(file.getOriginalFilename());
////                    files.setFileName(file.getOriginalFilename());
////                    //设置文件名 后期改为具体路径？
////                    //文件处理类，在数据库中保存文件路径
////                    filesService.save(files);
//            }
//        }
//    }

}
