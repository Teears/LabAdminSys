package ltd.syskaoqin.springboot.controller;

import ltd.syskaoqin.springboot.dao.entity.FeedBack;
import ltd.syskaoqin.springboot.service.FeedBackService;
import ltd.syskaoqin.springboot.util.JWTUtil;
import ltd.syskaoqin.springboot.util.result.Result;
import ltd.syskaoqin.springboot.util.result.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName FeedBackController
 * @Description TODO
 * @createTime 2021年03月22日22:54
 */
@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Resource
    private FeedBackService feedBackService;

    @PostMapping(value = "/addfeedback")
    @ResponseBody
    public Result addFeedBack(@RequestParam Map<String, String> param, HttpServletRequest request){
        String token = request.getHeader("token");
        String openid = JWTUtil.getUsername(token);
        String content = param.get("content");
        FeedBack feedBack = new FeedBack();
        feedBack.setContent(content);
        feedBack.setOpenid(openid);
        feedBackService.insertFeedBack(feedBack);
        return ResultUtils.success();
    }

    @PostMapping(value = "/getfeedback")
    @ResponseBody
    public Result getFeedBack(){
        return ResultUtils.success(feedBackService.selectAll());
    }
}
