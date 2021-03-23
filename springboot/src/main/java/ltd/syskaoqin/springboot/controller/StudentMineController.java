package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.dao.entity.Teacher;
import ltd.syskaoqin.springboot.dao.entity.User;
import ltd.syskaoqin.springboot.service.*;
import ltd.syskaoqin.springboot.util.JWTUtil;
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
 * @ClassName StudentMineController
 * @Description TODO 学生个人信息相关接口
 * @createTime 2021年03月21日14:36
 */
@RestController
@RequestMapping("/stu/mine")
public class StudentMineController {
    @Resource
    UserService userService;
    @Resource
    LabService labService;
    @Resource
    StudentService studentService;
    @Resource
    TeacherService teacherService;

    @GetMapping(value = "/getNameAndBelong")
    @ResponseBody
    public Result getNameAndBelong(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Map<String,String> data = new HashMap<>();
        String belong = labService.findLabByOpenid(openid).getLabNumber();
        User user = userService.findUserByopenid(openid);
        String stuName = studentService.findStudentByStuNumber(user.getBindId()).getName();
        data.put("stuName",stuName);
        data.put("belong",belong);
        data.put("avatarUrl",user.getAvatarUrl());
        return ResultUtils.success(data);
    }

    @GetMapping(value = "/shiyanshi")
    @ResponseBody
    public Result getLabDesc(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Lab lab = labService.findLabByOpenid(openid);
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

    @GetMapping(value = "/getbindinfo")
    @ResponseBody
    public Result getBindInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Map<String,String> data = new HashMap<>();
        Student student = studentService.findStudentByOpenid(openid);
        data.put("sex",student.getSex());
        data.put("stuNum",student.getStuNumber());
        data.put("phone",student.getPhone());
        data.put("dept",student.getDepartment());
        data.put("major",student.getMajor());
        return ResultUtils.success(data);
    }

    @PostMapping(value = "/exitlab")
    @ResponseBody
    public Result stuExitLab(@RequestParam Map<String, String> param){
        String stuNum = param.get("stuNum");
        if(studentService.deleteStudent(stuNum) > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.error(-200,"操作失败");
        }
    }
}
