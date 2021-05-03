package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.service.TeacherService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName BindRole
 * @Description TODO 教师Mine页面接口
 * @createTime 2021年02月22日20:22
 */
@RestController
@RequestMapping("/tea/mine")
public class TeacherMineController {
    @Resource
    private TeacherService teacherService;

    @GetMapping(value = "/getTeaName")
    @ResponseBody
    public Result getTeaName(HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Map<String,String> name = teacherService.findTeaName(openid);
        return ResultUtils.success(name);
    }

}
