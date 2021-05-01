package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.entity.Teacher;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.StudentService;
import ltd.syskaoqin.springboot.service.TeacherService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName STCommonController
 * @Description TODO
 * @createTime 2021年03月24日18:17
 */
@RestController
@RequestMapping("/common/")
public class StuTeaCommonController {
    @Resource
    LabService labService;
    @Resource
    TeacherService teacherService;

    @GetMapping(value = "/shiyanshiInfo")
    @ResponseBody
    public Result getLabDesc(HttpServletRequest request,String labId){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Lab lab;
        if(labId.length()>0){
            lab = labService.findLabByLabId(labId);
        }else {
            lab = labService.findLabByStuOpenid(openid);
        }
        Map<String,String> data = new HashMap<>();
        data.put("name",lab.getName());
        data.put("basicDesc",lab.getBasicDesc());
        data.put("ruleDesc",lab.getRuleDesc());
        data.put("imgUrl",lab.getPicUrl());
        data.put("createTime",lab.getReviseTime());

        Teacher teacher = teacherService.findTeacherByLabId(lab.getId());
        data.put("phone",teacher.getPhone());
        data.put("teaName",teacher.getName());

        return ResultUtils.success(data);
    }

}
