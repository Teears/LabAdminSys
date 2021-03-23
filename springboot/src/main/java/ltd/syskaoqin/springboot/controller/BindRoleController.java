package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.service.StudentService;
import ltd.syskaoqin.springboot.service.UserService;
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
    private UserService userService;

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
            data.put("roleId","1");
            data.put("isBinded","1");
        }
        return ResultUtils.success(data);
    }

}
