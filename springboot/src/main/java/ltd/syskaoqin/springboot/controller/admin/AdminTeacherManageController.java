package ltd.syskaoqin.springboot.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ltd.syskaoqin.springboot.dao.entity.Teacher;
import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import ltd.syskaoqin.springboot.service.TeacherService;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/11日09:52
 */
@RestController
@RequestMapping("/admin/teacher")
public class AdminTeacherManageController {

    @Resource
    private TeacherService teacherService;
    @Resource
    private UserAndLabService userAndLabService;

    @GetMapping(value = "/getTeacherList")
    @ResponseBody
    public Result getTeacherList(String content,int currentPage,int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String,String>> teacherList = null;
        if(content == null || "".equals(content)){
            teacherList = teacherService.getAllTeacherList();
        }else {
            teacherList = teacherService.getTeacherListByContent(content);
        }
        PageInfo<Map<String,String>> info = new PageInfo<>(teacherList);
        return ResultUtils.success(info);
    }

    @GetMapping(value = "/checkTeacher")
    @ResponseBody
    public Result checkTeacher(String num,String labId) {
        Map<String,String> teacher = teacherService.checkTeacher(num,labId);
        if(teacher == null){
            return ResultUtils.error(-1,"用户不存在或已添加");
        }else {
            return ResultUtils.success(teacher);
        }
    }

    @PostMapping(value = "/addTeacher")
    public Result addTeacher(@RequestBody Map<String, String> param){
        String num = param.get("num");
        String labId = param.get("labId");
        Teacher teacher = teacherService.findTeacherInSys(num);
        UserAndLab userAndLab = new UserAndLab();
        userAndLab.setStuNumber(num);
        userAndLab.setLabId(labId);
        try {
            teacherService.insertTeacher(teacher);
        }catch (DuplicateKeyException e){
            e.printStackTrace();
        }
        userAndLabService.insertUserLabTea(userAndLab);
        return ResultUtils.success();
    }

    @PostMapping(value = "/deleteTeacher")
    public Result deleteTeacher(@RequestBody Map<String, String> param){
        String num = param.get("num");
        String labId = param.get("labId");
        userAndLabService.deleteByTeaNumber(num,labId);
        List<UserAndLab> userAndLabList = userAndLabService.findByTeaNumber(num);
        if(userAndLabList == null){
            teacherService.deleteTeacher(num);
        }
        return ResultUtils.success();
    }
}
