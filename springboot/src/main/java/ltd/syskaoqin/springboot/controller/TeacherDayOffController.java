package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping(value = "/getDayOffList")
    @ResponseBody
    public Result getTeaName(HttpServletRequest request) {


        return ResultUtils.success();
    }
}
