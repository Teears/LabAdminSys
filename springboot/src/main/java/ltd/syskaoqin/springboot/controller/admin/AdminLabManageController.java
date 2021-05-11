package ltd.syskaoqin.springboot.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ltd.syskaoqin.springboot.dao.entity.Lab;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/11日16:34
 */
@RestController
@RequestMapping("/admin/lab")
public class AdminLabManageController {

    @Resource
    private LabService labService;

    @GetMapping(value = "/getLabList")
    @ResponseBody
    public Result getLabList(String content, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String,String>> labList = null;
        if(content == null || "".equals(content)){
            labList = labService.getAllLabList();
        }else {
            labList = labService.getLabListByContent(content);
        }
        PageInfo<Map<String,String>> info = new PageInfo<>(labList);
        return ResultUtils.success(info);
    }

    @PostMapping(value = "/updateLab")
    public Result updateLab(@RequestBody Map<String,Map<String,String>> param){
        Map<String,String> updateForm = param.get("updateForm");
        Lab lab = new Lab();
        lab.setId(updateForm.get("id"));
        lab.setLabNumber(updateForm.get("num"));
        lab.setName(updateForm.get("name"));
        lab.setSeat(updateForm.get("seat"));
        lab.setRoom(updateForm.get("room"));
        lab.setAddress(updateForm.get("address"));
        labService.updateLabAdminInfo(lab);
        return ResultUtils.success();
    }

    @PostMapping(value = "/addLab")
    public Result addLab(@RequestBody Map<String,Map<String,String>> param){
        Map<String,String> addForm = param.get("addForm");
        Lab lab = new Lab();
        lab.setLabNumber(addForm.get("num"));
        lab.setName(addForm.get("name"));
        lab.setSeat(addForm.get("seat"));
        lab.setRoom(addForm.get("room"));
        lab.setAddress(addForm.get("address"));
        labService.addLab(lab);
        return ResultUtils.success();
    }

    @PostMapping(value = "/deleteLab")
    public Result deleteLab(@RequestBody Map<String, String> param){
        String id = param.get("id");
        labService.deleteLab(id);
        return ResultUtils.success();
    }

    @GetMapping(value = "/getDetail")
    @ResponseBody
    public Result getDetail(String id) {
        return ResultUtils.success(labService.findLabByLabId(id));
    }
}
