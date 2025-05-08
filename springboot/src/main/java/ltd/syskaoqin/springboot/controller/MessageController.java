package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.Message;
import ltd.syskaoqin.springboot.service.LabService;
import ltd.syskaoqin.springboot.service.MessageService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName MessageController
 * @Description TODO 与站内信相关功能接口
 * @createTime 2021年03月22日13:27
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping(value = "/stu/getmessage")
    @ResponseBody
    public Result getMessage(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        List<Map<String,Object>> list = new ArrayList<>();
        List<Message> messageList = messageService.stuGetMessageList(openid,15);
        List<String> readedList = messageService.readedList(openid);
        for(Message message: messageList){
            Map<String,Object> data = new HashMap<>(5);
            data.put("id",message.getId());
            data.put("title",message.getTitle());
            data.put("content",message.getContent());
            data.put("day",message.getCreateTime().substring(0,10));
            data.put("time",message.getCreateTime().substring(11,16));
            if(readedList.contains(message.getId())){
                data.put("dot",false);
            }else {
                data.put("dot",true);
            }
            list.add(data);
        }
        return ResultUtils.success(list);
    }

    @GetMapping(value = "/setreaded")
    @ResponseBody
    public Result setReaded(HttpServletRequest request,String id){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        messageService.insertMessageTag(openid,id);
        return ResultUtils.success();
    }

    @PostMapping(value = "/tea/addPost")
    @ResponseBody
    public Result addPost(String title,String content,@RequestParam(value = "labIdList") String[] labIdList, HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        Message message = new Message();
        message.setContent(content);
        message.setTitle(title);
        message.setSendId(openid);
        for(String labId: labIdList){
            message.setLabId(labId);
            messageService.insertMessage(message);
        }
        return ResultUtils.success();
    }

    @GetMapping(value = "/tea/getPost")
    @ResponseBody
    public Result getAdd(HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        List<Message> messageList = messageService.selectMessageBySendId(openid);
        return ResultUtils.success(messageList);
    }
}
