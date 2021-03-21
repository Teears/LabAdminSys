package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.StudentService;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import ltd.syskaoqin.springboot.service.UserService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
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

    @GetMapping(value = "/getNameAndBelong")
    @ResponseBody
    public Result getNameAndBelong(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Map<String,String> data = new HashMap<>();
        String belong = labService.findLabByOpenid(openid).getLabNumber();
        String stuName = studentService.findStudentByStuNumber(userService.findUserByopenid(openid).getBindId()).getName();
        data.put("stuName",stuName);
        data.put("belong",belong);
        return ResultUtils.success(data);
    }
}
