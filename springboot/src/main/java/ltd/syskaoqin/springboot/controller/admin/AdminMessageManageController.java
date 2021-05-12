package ltd.syskaoqin.springboot.controller.admin;

import ltd.syskaoqin.springboot.dao.entity.Message;
import ltd.syskaoqin.springboot.service.FeedBackService;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.MessageService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    @Resource
    private FeedBackService feedBackService;

    @GetMapping(value = "/getPageList")
    @ResponseBody
    public Result getPageList(HttpServletRequest request) {
        String token = request.getHeader("token");
        String id = JWTUtil.getUsername(token);
        List<Message> messageList = messageService.selectMessageBySendId(id);
        List<Map<String,String>> feedbackList = feedBackService.selectFeedBack();
        Map<String,Object> data = new HashMap<>();
        data.put("messageList",messageList);
        data.put("feedbackList",feedbackList);
        return ResultUtils.success(data);
    }

    @PostMapping(value = "/addMessage")
    public Result addMessage(HttpServletRequest request,@RequestBody Map<String, Map<String,Object>> param){
        String token = request.getHeader("token");
        String id = JWTUtil.getUsername(token);
        Map<String,Object> form = param.get("form");
        Message message = new Message();
        message.setTitle(form.get("title").toString());
        message.setSendId(id);
        message.setContent(form.get("content").toString());
        message.setType("1");
        messageService.insertMessage(message);

        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return ResultUtils.success(df.format(day));
    }
}
