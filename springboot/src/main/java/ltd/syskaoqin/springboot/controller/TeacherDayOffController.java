package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.service.DayOffService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName TeacherDayOffController
 * @Description TODO 教师请假审批页面接口
 * @createTime 2021年02月22日20:22
 */
@RestController
@RequestMapping("/tea/dayOff/")
public class TeacherDayOffController {

    @Resource
    private DayOffService dayOffService;

    @GetMapping(value = "/getDayOffList")
    @ResponseBody
    public Result getTeaName(HttpServletRequest request) {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        List<Map<String,String>> dayOffList = dayOffService.findTeaDayOffList(openid);
        return ResultUtils.success(dayOffList);
    }

    @GetMapping(value = "/agree")
    @ResponseBody
    public Result setAgree(HttpServletRequest request,@RequestParam String id) {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        dayOffService.setAgree(openid,id);
        return ResultUtils.success();
    }

    @GetMapping(value = "/refuse")
    @ResponseBody
    public Result setRefuse(HttpServletRequest request,@RequestParam String id) {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        dayOffService.setRefuse(openid,id);
        return ResultUtils.success();
    }

    @GetMapping(value = "/reverse")
    @ResponseBody
    public Result setReverse(HttpServletRequest request,@RequestParam String id) {
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        dayOffService.setReverse(openid,id);
        return ResultUtils.success();
    }
}
