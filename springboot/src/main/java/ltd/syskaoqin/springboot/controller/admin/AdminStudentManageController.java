package ltd.syskaoqin.springboot.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.dao.entity.Student;
import ltd.syskaoqin.springboot.dao.entity.UserAndLab;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.StudentService;
import ltd.syskaoqin.springboot.service.UserAndLabService;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/11日14:26
 */
@RestController
@RequestMapping("/admin/student")
public class AdminStudentManageController {
    @Resource
    private StudentService studentService;
    @Resource
    private LabService labService;
    @Resource
    private UserAndLabService userAndLabService;

    @GetMapping(value = "/getStudentList")
    @ResponseBody
    public Result getStudentList(String content, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String,String>> studentList = null;
        if(content == null || "".equals(content)){
            studentList = studentService.getAllStudentList();
        }else {
            studentList = studentService.getStudentListByContent(content);
        }
        PageInfo<Map<String,String>> info = new PageInfo<>(studentList);
        return ResultUtils.success(info);
    }

    @GetMapping(value = "/checkStudent")
    @ResponseBody
    public Result checkStudent(String num,String labId) {
        Map<String,String> student = studentService.checkStudent(num);
        Lab lab = labService.findLabByLabId(labId);
        if(student == null || lab == null){
            return ResultUtils.error(-1,"用户和实验室不存在或已添加");
        }else {
            return ResultUtils.success(student);
        }
    }

    @PostMapping(value = "/addStudent")
    public Result addStudent(@RequestBody Map<String, String> param){
        String num = param.get("num");
        String labId = param.get("labId");
        Student student = studentService.findStudentInSys(num);
        UserAndLab userAndLab = new UserAndLab();
        userAndLab.setStuNumber(num);
        userAndLab.setLabId(labId);
        userAndLabService.insertUserLab(userAndLab);
        studentService.insertStudent(student);
        return ResultUtils.success();
    }

    @PostMapping(value = "/deleteStudent")
    public Result deleteStudent(@RequestBody Map<String, String> param){
        String num = param.get("num");
        studentService.deleteStudent(num);
        userAndLabService.deleteByStuNumber(num);
        return ResultUtils.success();
    }
}
