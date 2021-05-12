package ltd.syskaoqin.springboot.controller.admin;

import ltd.syskaoqin.springboot.service.MessageService;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Tears
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月2021/5/12日10:36
 */
@RestController
@RequestMapping("/admin/message")
public class AdminMessageManageController {

    @Resource
    private MessageService messageService;

    @GetMapping(value = "/getPageList")
    @ResponseBody
    public Result getPageList() {
        messageService.selectMessageBySendId()

        return ResultUtils.success();
    }

    @PostMapping(value = "/addMessage")
    public Result addMessage(@RequestBody Map<String, Map<String,String>> param){
        Map<String,String> form = param.get("form");

        return ResultUtils.success();
    }
}
