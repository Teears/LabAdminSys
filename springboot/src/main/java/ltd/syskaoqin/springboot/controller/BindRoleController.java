package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.dao.entity.Teacher;
import ltd.syskaoqin.springboot.service.StudentService;
import ltd.syskaoqin.springboot.service.TeacherService;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import ltd.syskaoqin.springboot.service.UserService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName BindRole
 * @Description TODO 学生和教师身份绑定接口
 * @createTime 2021年02月22日20:22
 */
@RestController
@RequestMapping("/bindId")
public class BindRoleController {
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private UserService userService;
    @Resource
    private UserAndLabService userAndLabService;

    @PostMapping(value = "/stu")
    @ResponseBody
    public Result bindIdStu(@RequestParam Map<String, String> param, HttpServletRequest request){
        String stuNumber = param.get("stuNumber");
        String stuPassword = param.get("stuPassword");
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Student stu = studentService.findStudentByStuNumber(stuNumber);
        Map<String,String> data = new HashMap<>();
        if (stu == null || !stuPassword.equals(stu.getSecret())){
            data.put("isBinded","0");
        }else {
            userService.updateBindAndRole(openid,stu.getStuNumber(),"1");
            userAndLabService.updateOpenid(openid,stuNumber);
            data.put("roleId","1");
            data.put("isBinded","1");
            UsernamePasswordToken aToken = new UsernamePasswordToken("WECHAT",openid);
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            subject.login(aToken);
        }
        return ResultUtils.success(data);
    }

    @PostMapping(value = "/tea")
    @ResponseBody
    public Result bindIdTea(@RequestParam Map<String, String> param, HttpServletRequest request){
        String teaNumber = param.get("teaNumber");
        String teaPassword = param.get("teaPassword");
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Teacher teacher = teacherService.findTeacherByTeaNumber(teaNumber);
        Map<String,String> data = new HashMap<>();
        if (teacher == null || !teaPassword.equals(teacher.getSecret())){
            data.put("isBinded","0");
        }else {
            userService.updateBindAndRole(openid,teacher.getTeaNumber(),"2");
            userAndLabService.updateTeaOpenid(openid,teaNumber);
            data.put("roleId","2");
            data.put("isBinded","1");
            UsernamePasswordToken aToken = new UsernamePasswordToken("WECHAT",openid);
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            subject.login(aToken);
        }
        return ResultUtils.success(data);
    }
}
